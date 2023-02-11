package com.nssproject.bookease.service.impl;

import com.nssproject.bookease.entity.BookStall;
import com.nssproject.bookease.entity.Stock;
import com.nssproject.bookease.repository.BookRepository;
import com.nssproject.bookease.repository.BookStallRepository;
import com.nssproject.bookease.repository.StockRepository;
import com.nssproject.bookease.service.BookStallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookStallServiceImpl implements BookStallService {

    private BookStallRepository bookStallRepository;
    private final StockRepository stockRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookStallServiceImpl(BookStallRepository bookStallRepository,
                                StockRepository stockRepository,
                                BookRepository bookRepository) {
        this.bookStallRepository = bookStallRepository;
        this.stockRepository = stockRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookStall> getBookStallByName(String name) {
        return bookStallRepository.findByNameContains(name);
    }

    @Override
    public List<BookStall> getStallByBook(Long bookId) {
        List<Stock> stocks =  stockRepository.findAllByBookId(bookId);
        List<String> stockIds = new ArrayList<>();
        stocks.forEach(stock -> stockIds.add(stock.getStallEmail()));
        List<BookStall> bookStalls = new ArrayList<>();
        stockIds.forEach(stockId -> bookStalls.add(bookStallRepository.findByEmail(stockId)));
        return bookStalls;
    }

    @Override
    public List<BookStall> getStallByDistrictAndBook(Long bookId, String district) {
        List<Stock> stocks =  stockRepository.findAllByBookId(bookId);
        List<String> stockIds = new ArrayList<>();
        stocks.forEach(stock -> {
            if(stock.getStock()>0){
            stockIds.add(stock.getStallEmail());}
        });
        List<BookStall> bookStalls = new ArrayList<>();
        stockIds.forEach(stockId -> {
            BookStall bookStall = bookStallRepository.findByEmail(stockId);
            if (district.equals(bookStall.getDistrict())){
                bookStalls.add(bookStall);
            }
        });
        return bookStalls;
    }

    @Override
    public BookStall getStallByEmail(String email) {
        return bookStallRepository.findByEmail(email);
    }

    @Override
    public List<BookStall> getByDistrict(String district) {
        return bookStallRepository.findByDistrict(district);
    }
}

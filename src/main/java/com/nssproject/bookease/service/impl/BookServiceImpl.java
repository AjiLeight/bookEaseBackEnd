package com.nssproject.bookease.service.impl;

import com.nssproject.bookease.entity.Book;
import com.nssproject.bookease.entity.Stock;
import com.nssproject.bookease.repository.BookRepository;
import com.nssproject.bookease.repository.StockRepository;
import com.nssproject.bookease.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private final StockRepository stockRepository;

    public BookServiceImpl(BookRepository bookRepository,
                           StockRepository stockRepository) {
        this.bookRepository = bookRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> listBookByName(String name) {
        return bookRepository.findAllByBookNameContainingOrderByBookName(name);
    }

    @Override
    public List<Book> listBookFromStock(Long id) {
        List<Stock> stock = stockRepository.findAllByBookId(id);
        List<Book> bookList = new ArrayList<>();
        stock.forEach(s -> {bookList.add(bookRepository.findById(s.getBookId()).orElseThrow());});
        return bookList;
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }


}

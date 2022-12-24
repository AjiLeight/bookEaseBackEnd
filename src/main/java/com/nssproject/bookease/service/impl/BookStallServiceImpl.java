package com.nssproject.bookease.service.impl;

import com.nssproject.bookease.entity.BookStall;
import com.nssproject.bookease.repository.BookStallRepository;
import com.nssproject.bookease.repository.StockRepository;
import com.nssproject.bookease.service.BookStallService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStallServiceImpl implements BookStallService {

    private BookStallRepository bookStallRepository;
    private final StockRepository stockRepository;

    public BookStallServiceImpl(BookStallRepository bookStallRepository,
                                StockRepository stockRepository) {
        this.bookStallRepository = bookStallRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public List<BookStall> getBookStallByName(String name) {
        return bookStallRepository.findByNameContains(name);
    }
}

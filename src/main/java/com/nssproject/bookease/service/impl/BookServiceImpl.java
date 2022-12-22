package com.nssproject.bookease.service.impl;

import com.nssproject.bookease.entity.Book;
import com.nssproject.bookease.repository.BookRepository;
import com.nssproject.bookease.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}

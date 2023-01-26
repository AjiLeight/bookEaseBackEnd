package com.nssproject.bookease.service;


import com.nssproject.bookease.entity.Book;
import com.nssproject.bookease.entity.Stock;

import java.util.List;

public interface BookService {
    Book saveBook( Book book);
    List<Book> listBookByName(String string);
    List<Book> listBookFromStock(Long id);
    Book getBookById(Long id);

}

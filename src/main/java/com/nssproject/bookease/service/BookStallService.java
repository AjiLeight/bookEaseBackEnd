package com.nssproject.bookease.service;

import com.nssproject.bookease.entity.BookStall;

import java.util.List;

public interface BookStallService {
    List<BookStall> getBookStallByName(String name);

}

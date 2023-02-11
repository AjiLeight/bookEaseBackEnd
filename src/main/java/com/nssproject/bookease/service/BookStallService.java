package com.nssproject.bookease.service;

import com.nssproject.bookease.entity.BookStall;

import java.util.List;

public interface BookStallService {
    List<BookStall> getBookStallByName(String name);
    List<BookStall> getStallByBook(Long bookId);
    List<BookStall> getStallByDistrictAndBook(Long bookId, String District);
    BookStall getStallByEmail(String email);
    List<BookStall> getByDistrict(String district);
}

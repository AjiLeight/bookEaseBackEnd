package com.nssproject.bookease.service;

import com.nssproject.bookease.entity.Stock;

import java.util.List;

public interface StockService {
    List<Stock> listBookByStallId(String email);
    Stock increaseStock(Long bookId, String email, int amount);
    Stock decreaseStock(Long bookId, String email, int amount);
}

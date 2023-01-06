package com.nssproject.bookease.service;

import com.nssproject.bookease.entity.Stock;

import java.util.List;

public interface StockService {
    List<Stock> listBookByStallId(Long id);
}

package com.nssproject.bookease.service.impl;

import com.nssproject.bookease.entity.Stock;
import com.nssproject.bookease.repository.StockRepository;
import com.nssproject.bookease.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> listBookByStallId(Long id) {
        return stockRepository.findByStallId(id);
    }
}

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
    public List<Stock> listBookByStallId(String id) {
        return stockRepository.findByStallEmail(id);
    }

    @Override
    public Stock increaseStock(Long bookId, String email, int amount) {
        Stock stock = stockRepository.findByStallEmailAndBookId(email, bookId);
        stock.setStock(stock.getStock()+amount);
        return stockRepository.save(stock);
    }

    @Override
    public Stock decreaseStock(Long bookId, String email, int amount) {
        Stock stock = stockRepository.findByStallEmailAndBookId(email, bookId);
        stock.setStock(stock.getStock()-amount);
        return stockRepository.save(stock);
    }


}

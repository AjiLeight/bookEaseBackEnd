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
        return stockRepository.findAllByStallEmail(id);
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

    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Long bookId, String stallEmail) {
        Stock stock = stockRepository.findByStallEmailAndBookId(stallEmail, bookId);
        stockRepository.delete(stock);
    }

    @Override
    public Stock updateStock(Stock newStock) {
        Stock stock = stockRepository.findByStallEmailAndBookId(newStock.getStallEmail(), newStock.getBookId());
        stock.setStock(newStock.getStock());
        return stockRepository.save(stock);
    }


}

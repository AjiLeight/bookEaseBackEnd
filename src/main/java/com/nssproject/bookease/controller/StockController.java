package com.nssproject.bookease.controller;

import com.nssproject.bookease.dto.StockDto;
import com.nssproject.bookease.entity.Stock;
import com.nssproject.bookease.repository.StockRepository;
import com.nssproject.bookease.service.StockService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/stock")
@CrossOrigin
public class StockController {
    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("increase")
    public Stock increaseStock(@RequestBody StockDto stockDto){
        return stockService.increaseStock(stockDto.getBookId(), stockDto.getEmail(),stockDto.getAmount());
    }
    @PostMapping("decrease")
    public Stock decreaseStock(@RequestBody StockDto stockDto){
        return stockService.decreaseStock(stockDto.getBookId(), stockDto.getEmail(),stockDto.getAmount());
    }
}

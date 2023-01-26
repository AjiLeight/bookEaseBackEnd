package com.nssproject.bookease.controller;

import com.nssproject.bookease.dto.StockDto;
import com.nssproject.bookease.entity.Stock;
import com.nssproject.bookease.repository.StockRepository;
import com.nssproject.bookease.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{email}")
    public ResponseEntity<List<Stock>> getStock(@PathVariable String email){
        return new ResponseEntity<>(stockService.listBookByStallId(email), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Stock> saveStock(@RequestBody StockDto stockDto){
        Stock stock = new Stock();
        stock.setBookId(stockDto.getBookId());
        stock.setStallEmail(stockDto.getEmail());
        stock.setStock(stockDto.getAmount());
        return ResponseEntity.ok(stockService.saveStock(stock));
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteStock(@RequestBody StockDto stockDto){
        stockService.deleteStock(stockDto.getBookId(),stockDto.getEmail());
        return ResponseEntity.ok("deleted successfully");
    }

    @PutMapping()
    public ResponseEntity<Stock> updateStock(@RequestBody StockDto stockDto){
        Stock stock = new Stock();
        stock.setBookId(stockDto.getBookId());
        stock.setStallEmail(stockDto.getEmail());
        stock.setStock(stockDto.getAmount());
        return ResponseEntity.ok(stockService.updateStock(stock));
    }

}

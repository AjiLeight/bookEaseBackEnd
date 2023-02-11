package com.nssproject.bookease.controller;


import com.nssproject.bookease.dto.DistrictDto;
import com.nssproject.bookease.entity.BookStall;
import com.nssproject.bookease.entity.Stock;
import com.nssproject.bookease.repository.StockRepository;
import com.nssproject.bookease.service.BookStallService;
import com.nssproject.bookease.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stall")
@CrossOrigin
public class BookStallController {
    private BookStallService bookStallService;
    private  StockService stockService;

    @Autowired
    public BookStallController(BookStallService bookStallService,
                               StockService stockService) {
        this.bookStallService = bookStallService;
        this.stockService = stockService;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<BookStall>> listBookStallByName(@PathVariable String name){
        return ResponseEntity.ok(bookStallService.getBookStallByName(name));
    }

    @PostMapping("/district")
    public  ResponseEntity<List<BookStall>> listBookStallByDistrictAndBook(@RequestBody DistrictDto districtDto){
        return ResponseEntity.ok(bookStallService.getStallByDistrictAndBook(districtDto.getBookId(),districtDto.getDistrict()));
    }

    @GetMapping("{email}")
    public ResponseEntity<BookStall> listBookStallByEmail(@PathVariable String email){
        return new ResponseEntity<>(bookStallService.getStallByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/district/{district}")
    public ResponseEntity<List<BookStall>> listBookStallByDistrict(@PathVariable String district){
        return new ResponseEntity<>(bookStallService.getByDistrict(district), HttpStatus.OK);
    }
}

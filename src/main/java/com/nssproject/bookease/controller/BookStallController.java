package com.nssproject.bookease.controller;


import com.nssproject.bookease.entity.BookStall;
import com.nssproject.bookease.service.BookStallService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stall")
public class BookStallController {
    private BookStallService bookStallService;

    public BookStallController(BookStallService bookStallService) {
        this.bookStallService = bookStallService;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<BookStall>> listBookStallByName(@PathVariable String name){
        return ResponseEntity.ok(bookStallService.getBookStallByName(name));
    }
}

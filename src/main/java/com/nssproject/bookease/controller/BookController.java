package com.nssproject.bookease.controller;

import com.nssproject.bookease.entity.Book;
import com.nssproject.bookease.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@CrossOrigin
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/save-book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.saveBook(book), HttpStatus.OK);
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<List> listBookByName(@PathVariable String name){
        return new ResponseEntity<>(bookService.listBookByName(name), HttpStatus.OK);
    }

    @GetMapping("/search/stall-id/{stallId}")
    public ResponseEntity<List> listBooksByStallName(@PathVariable Long stallId){
        return new ResponseEntity<List>(bookService.listBookFromStock(stallId), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

}

package com.nssproject.bookease.repository;

import com.nssproject.bookease.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByBookNameContaining(String name);
    List<Book> findAllByBookNameContainingOrderByBookName(String name);


}

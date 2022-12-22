package com.nssproject.bookease.repository;

import com.nssproject.bookease.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

package com.nssproject.bookease.repository;

import com.nssproject.bookease.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findAllByStallEmail(String email);
    List<Stock> findAllByBookId(Long Id);
    Stock findByStallEmailAndBookId(String email, Long id);
}

package com.nssproject.bookease.repository;

import com.nssproject.bookease.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByStallEmail(String email);
    List<Stock> findByBookId(Long Id);
}

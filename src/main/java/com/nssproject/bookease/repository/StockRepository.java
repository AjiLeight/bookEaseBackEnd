package com.nssproject.bookease.repository;

import com.nssproject.bookease.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}

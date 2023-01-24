package com.nssproject.bookease.dto;

import lombok.Data;

@Data
public class StockDto {
    private Long bookId;
    private String email;
    private int amount;
}

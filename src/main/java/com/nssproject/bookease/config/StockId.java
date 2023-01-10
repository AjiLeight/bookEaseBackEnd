package com.nssproject.bookease.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockId implements Serializable {
    private Long bookId;
    private String stallEmail;
}

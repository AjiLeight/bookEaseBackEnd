package com.nssproject.bookease.entity;

import com.nssproject.bookease.config.StockId;
import jakarta.persistence.*;

@Entity
@Table(name = "stock")
@IdClass(StockId.class)
public class Stock {

    @Id
    private long bookId;

    @Id
    private long stallId;

    @Column
    private long stock;


    public Stock() {
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getStallId() {
        return stallId;
    }

    public void setStallId(long stallId) {
        this.stallId = stallId;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
}

package com.nssproject.bookease.entity;

import com.nssproject.bookease.config.StockId;
import javax.persistence.*;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock1 = (Stock) o;
        return bookId == stock1.bookId && stallId == stock1.stallId && stock == stock1.stock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, stallId, stock);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "bookId=" + bookId +
                ", stallId=" + stallId +
                ", stock=" + stock +
                '}';
    }
}

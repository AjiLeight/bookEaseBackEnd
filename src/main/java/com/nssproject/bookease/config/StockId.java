package com.nssproject.bookease.config;

import java.io.Serializable;

public class StockId implements Serializable {
    private Long bookId;
    private Long stallId;

    public StockId() {
    }

    public StockId(Long bookId, Long stallId) {
        this.bookId = bookId;
        this.stallId = stallId;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        StockId stockId = (StockId) o;
        return bookId.equals(stockId.bookId)&& stallId.equals(stockId.stallId);
    }
}

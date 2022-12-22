package com.nssproject.bookease.config;

import java.io.Serializable;
import java.util.Objects;

public class ReservationId implements Serializable {
    private String userId;
    private String stallId;
    private String bookId;

    public ReservationId() {
    }

    public ReservationId(String userId, String stallId, String bookId) {
        this.userId = userId;
        this.stallId = stallId;
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o == null || getClass()!= o.getClass()) return false;
        ReservationId reservationId = (ReservationId) o;
        return userId.equals(reservationId.userId) && bookId.equals(reservationId.bookId) && stallId.equals(reservationId.stallId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(userId, bookId, stallId);
    }

}

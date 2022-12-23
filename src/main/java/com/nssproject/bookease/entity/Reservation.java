package com.nssproject.bookease.entity;

import com.nssproject.bookease.config.ReservationId;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reservations")
@IdClass(ReservationId.class)
public class Reservation {
    @Id
    @Column(nullable = false)
    private Long bookId;
    @Id
    @Column(nullable = false)
    private Long stallId;
    @Id
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private Date date;


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getStallId() {
        return stallId;
    }

    public void setStallId(Long stallId) {
        this.stallId = stallId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Reservation() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(bookId, that.bookId) && Objects.equals(stallId, that.stallId) && Objects.equals(userId, that.userId) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, stallId, userId, date);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "bookId=" + bookId +
                ", stallId=" + stallId +
                ", userId=" + userId +
                ", date=" + date +
                '}';
    }
}

package com.nssproject.bookease.entity;

import com.nssproject.bookease.config.ReservationId;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@IdClass(ReservationId.class)
public class Reservation {
    @Id
    @Column(nullable = false)
    private Long bookId;
    @Id
    @Column(nullable = false)
    private String stallEmail;
    @Id
    @Column(nullable = false)
    private String userEmail;
    @Column(nullable = false)
    private Date date;
}

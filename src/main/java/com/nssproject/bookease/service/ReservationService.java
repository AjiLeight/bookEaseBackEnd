package com.nssproject.bookease.service;

import com.nssproject.bookease.entity.BookStall;
import com.nssproject.bookease.entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation);
}

package com.nssproject.bookease.service;

import com.nssproject.bookease.config.ReservationId;
import com.nssproject.bookease.dto.RegisterStallDto;
import com.nssproject.bookease.dto.ReservationDto;
import com.nssproject.bookease.entity.BookStall;
import com.nssproject.bookease.entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation);
    List<Reservation> getReservationByStallEmail(String email);
    List<Reservation> getReservationByUserEmail(String email);

    void deleteReservation(ReservationDto reservationDto);
    void completeReservation(ReservationDto reservationDto);
    void reservationReminder();
}

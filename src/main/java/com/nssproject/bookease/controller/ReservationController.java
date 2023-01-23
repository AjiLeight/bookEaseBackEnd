package com.nssproject.bookease.controller;

import com.nssproject.bookease.dto.ReservationDto;
import com.nssproject.bookease.entity.Reservation;
import com.nssproject.bookease.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    @Autowired
    private final ReservationService reservationService;

    @PostMapping
    public Reservation addReservation(@RequestBody ReservationDto reservationDto){
        Reservation reservation = new Reservation();
        reservation.setBookId(reservationDto.getBookId());
        reservation.setUserEmail(reservationDto.getUserEmail());
        reservation.setStallEmail(reservationDto.getStallEmail());
        reservation.setDate(new Date());
        return reservationService.addReservation(reservation);
    }
}

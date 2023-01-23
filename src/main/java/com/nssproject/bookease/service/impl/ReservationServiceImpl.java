package com.nssproject.bookease.service.impl;

import com.nssproject.bookease.config.ReservationId;
import com.nssproject.bookease.entity.Reservation;
import com.nssproject.bookease.repository.ReservationRepository;
import com.nssproject.bookease.service.ReservationService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getReservationByStallEmail(String email) {
        return reservationRepository.findAllByStallEmailOrderByDateDesc(email);
    }

    @Override
    public List<Reservation> getReservationByUserEmail(String email) {
        return reservationRepository.findAllByUserEmail(email);
    }

    @Override
    public void deleteReservation(ReservationId reservationId) {
        Reservation reservation = reservationRepository.findByBookIdAndStallEmailAndUserEmail(
                reservationId.getBookId(),
                reservationId.getStallEmail(),
                reservationId.getUserEmail());
        reservationRepository.delete(reservation);
    }
}

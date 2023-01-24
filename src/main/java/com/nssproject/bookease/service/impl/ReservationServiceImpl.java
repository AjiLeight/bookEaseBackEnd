package com.nssproject.bookease.service.impl;

import com.nssproject.bookease.config.ReservationId;
import com.nssproject.bookease.dto.ReservationDto;
import com.nssproject.bookease.entity.Reservation;
import com.nssproject.bookease.entity.Stock;
import com.nssproject.bookease.repository.ReservationRepository;
import com.nssproject.bookease.service.ReservationService;
import com.nssproject.bookease.service.StockService;
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
    @Autowired
    private StockService stockService;
    @Override
    public Reservation addReservation(Reservation reservation) {
        stockService.decreaseStock(reservation.getBookId(),reservation.getStallEmail(),1);
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
    public void deleteReservation(ReservationDto reservationDto) {
        Reservation reservation = reservationRepository.findByBookIdAndStallEmailAndUserEmail(
                reservationDto.getBookId(),
                reservationDto.getStallEmail(),
                reservationDto.getUserEmail());
        stockService.increaseStock(reservationDto.getBookId(),reservationDto.getStallEmail(),1);
        reservationRepository.delete(reservation);
    }
}

package com.nssproject.bookease.repository;

import com.nssproject.bookease.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUserEmail(String email);
    List<Reservation> findAllByStallEmailOrderByDateDesc(String email);
    Reservation findByBookIdAndStallEmailAndUserEmail(Long id, String stall, String user);
}

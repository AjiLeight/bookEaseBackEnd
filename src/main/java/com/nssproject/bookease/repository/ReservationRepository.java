package com.nssproject.bookease.repository;

import com.nssproject.bookease.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

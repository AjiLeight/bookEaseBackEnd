package com.nssproject.bookease;

import com.nssproject.bookease.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class BookEaseApplication {
	@Autowired
	private ReservationService reservationService;

	public static void main(String[] args) {
		SpringApplication.run(BookEaseApplication.class, args);
	}

	@Scheduled(fixedRate = 30000)
	public String checkReservation(){
		System.out.println("Reservation check initiated");
		reservationService.reservationReminder();
		System.out.println("Reservation check completed");
		return ("Schedule check");
	}

}

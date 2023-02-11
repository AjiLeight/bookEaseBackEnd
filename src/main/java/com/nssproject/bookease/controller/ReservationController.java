package com.nssproject.bookease.controller;

import com.nssproject.bookease.config.ReservationId;
import com.nssproject.bookease.dto.ReservationDto;
import com.nssproject.bookease.entity.EmailDetails;
import com.nssproject.bookease.entity.Reservation;
import com.nssproject.bookease.service.BookService;
import com.nssproject.bookease.service.EmailService;
import com.nssproject.bookease.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    @Autowired
    private final ReservationService reservationService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private BookService bookService;
    @PostMapping
    public Reservation addReservation(@RequestBody ReservationDto reservationDto){
        Reservation reservation = new Reservation();
        reservation.setBookId(reservationDto.getBookId());
        reservation.setUserEmail(reservationDto.getUserEmail());
        reservation.setStallEmail(reservationDto.getStallEmail());
        reservation.setDate(new Date());
        return reservationService.addReservation(reservation);
    }

    @GetMapping("user/{email}")
    public List<Reservation> getReservationByUserId(@PathVariable("email") String email){
        return reservationService.getReservationByUserEmail(email);
    }

    @GetMapping("stall/{email}")
    public List<Reservation> getReservationByStallId(@PathVariable("email") String email){
        return reservationService.getReservationByStallEmail(email);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteReservation(@RequestBody ReservationDto reservationDto){
        reservationService.deleteReservation(reservationDto);
        return ResponseEntity.ok("deleted successfully");
    }

    @DeleteMapping("/complete")
    public ResponseEntity<String> completeReservation(@RequestBody ReservationDto reservationDto){
        reservationService.completeReservation(reservationDto);

        String bookName = bookService.getBookById(reservationDto.getBookId()).getBookName();

        EmailDetails emailDetails = new EmailDetails();

        emailDetails.setRecipient(reservationDto.getUserEmail());
        emailDetails.setSubject("Purchase Complete");
        emailDetails.setMessageBody("Hi \n\n Your purchase of book "+bookName+" has been completed \n\n Thanks, \n Book Ease Team");
        String res = emailService.sendSimpleEmail(emailDetails);

        return ResponseEntity.ok(res);
    }
}

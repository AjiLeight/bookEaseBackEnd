package com.nssproject.bookease.service.impl;

import com.nssproject.bookease.config.ReservationId;
import com.nssproject.bookease.dto.ReservationDto;
import com.nssproject.bookease.entity.EmailDetails;
import com.nssproject.bookease.entity.Reservation;
import com.nssproject.bookease.entity.Stock;
import com.nssproject.bookease.repository.ReservationRepository;
import com.nssproject.bookease.service.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private StockService stockService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookStallService bookStallService;
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

    @Override
    public void completeReservation(ReservationDto reservationDto) {
        Reservation reservation = reservationRepository.findByBookIdAndStallEmailAndUserEmail(
                reservationDto.getBookId(),
                reservationDto.getStallEmail(),
                reservationDto.getUserEmail());
        reservationRepository.delete(reservation);
    }

    @Override
    public void reservationReminder() {
        List<Reservation> reservations = reservationRepository.findAll();
        reservations.forEach(reservation -> {
            Date today = new Date();
            long differenceInTime = today.getTime() - reservation.getDate().getTime();
            long differenceInSeconds = (differenceInTime/1000)%60;
            if(differenceInSeconds>30){
                String bookName = bookService.getBookById(reservation.getBookId()).getBookName();
                String stallName = bookStallService.getStallByEmail(reservation.getStallEmail()).getName();
                EmailDetails emailDetails = new EmailDetails();
                emailDetails.setRecipient(reservation.getUserEmail());
                emailDetails.setSubject("Reminder for Purchase");
                emailDetails.setMessageBody("Hi, \n\n Your Purchase of "+bookName+" is due.\n Kindly visit "+stallName+" and purchase you book \n\n Thanks,\n Book Ease team");
                emailService.sendSimpleEmail(emailDetails);
                System.out.println("Email sent to user :"+ reservation.getUserEmail());
            }
        });
    }
}

package com.nssproject.bookease.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationDto {
    private Long bookId;
    private String stallEmail;
    private String userEmail;

    ReservationDto(Long bookId, String stallEmail, String userEmail){
        this.bookId = bookId;
        this.stallEmail = stallEmail;
        this.userEmail = userEmail;
    }

}

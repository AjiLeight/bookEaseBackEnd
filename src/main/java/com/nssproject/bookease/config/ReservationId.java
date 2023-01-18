package com.nssproject.bookease.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationId implements Serializable {
    private String userEmail;
    private String stallEmail;
    private Long bookId;

}

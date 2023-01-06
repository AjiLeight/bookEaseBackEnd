package com.nssproject.bookease.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String password;
    private String role;
}

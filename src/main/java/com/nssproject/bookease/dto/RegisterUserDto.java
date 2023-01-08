package com.nssproject.bookease.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String name;

    private String email;
    private String password;
}

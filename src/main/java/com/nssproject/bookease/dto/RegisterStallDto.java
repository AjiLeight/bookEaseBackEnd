package com.nssproject.bookease.dto;

import lombok.Data;

@Data
public class RegisterStallDto {
    private String name;
    private String email;
    private String password;
    private String address;
    private String district;
    private String city;
    private String phone;
}

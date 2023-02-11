package com.nssproject.bookease.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer ";
    private String role;

    public AuthResponseDto(String accessToken){this.accessToken = accessToken;}

    public AuthResponseDto(String accessToken, String role) {
        this.accessToken = accessToken;
        this.role = role;
    }
}

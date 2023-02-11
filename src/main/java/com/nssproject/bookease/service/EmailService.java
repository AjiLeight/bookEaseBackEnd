package com.nssproject.bookease.service;

import com.nssproject.bookease.entity.EmailDetails;

public interface EmailService {
    String sendSimpleEmail(EmailDetails details);
}

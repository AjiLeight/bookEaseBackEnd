package com.nssproject.bookease.controller;

import com.nssproject.bookease.entity.EmailDetails;
import com.nssproject.bookease.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mail")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping()
    public ResponseEntity<String> sendMail(@RequestBody EmailDetails emailDetails){
        return new ResponseEntity<>(emailService.sendSimpleEmail(emailDetails), HttpStatus.OK);
    }
}

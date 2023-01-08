package com.nssproject.bookease.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book_stall")
@Data
@NoArgsConstructor
public class BookStall {

    @Id()
    private String email;
    private String name;

    private String address;

    private String district;

    private String city;

    private String contact;

}

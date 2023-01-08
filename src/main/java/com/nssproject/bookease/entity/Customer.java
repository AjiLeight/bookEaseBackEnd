package com.nssproject.bookease.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.util.Objects;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    private String email;

    private String name;

}

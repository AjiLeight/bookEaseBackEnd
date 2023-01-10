package com.nssproject.bookease.entity;

import com.nssproject.bookease.config.StockId;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.util.Objects;

@Entity
@Table(name = "stock")
@Data
@NoArgsConstructor
@IdClass(StockId.class)
public class Stock {

    @Id
    private long bookId;

    @Id
    private String stallEmail;

    @Column
    private long stock;



}

package com.nssproject.bookease.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "book_stall")
public class BookStall {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false, unique = true)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BookStall() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookStall bookStall = (BookStall) o;
        return Objects.equals(id, bookStall.id) && Objects.equals(name, bookStall.name) && Objects.equals(address, bookStall.address) && Objects.equals(district, bookStall.district) && Objects.equals(city, bookStall.city) && Objects.equals(contact, bookStall.contact) && Objects.equals(password, bookStall.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, district, city, contact, password);
    }

    @Override
    public String toString() {
        return "BookStall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", contact='" + contact + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

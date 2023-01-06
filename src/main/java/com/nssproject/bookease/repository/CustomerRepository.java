package com.nssproject.bookease.repository;

import com.nssproject.bookease.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

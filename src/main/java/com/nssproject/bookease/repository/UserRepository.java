package com.nssproject.bookease.repository;

import com.nssproject.bookease.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

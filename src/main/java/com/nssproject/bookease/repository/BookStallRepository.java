package com.nssproject.bookease.repository;

import com.nssproject.bookease.entity.BookStall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookStallRepository extends JpaRepository<BookStall, Long> {
    List<BookStall> findByNameContains(String name);
    BookStall findByEmail(String email);
    List<BookStall> findByDistrict(String district);

}

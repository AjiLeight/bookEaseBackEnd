package com.nssproject.bookease.repository;

import com.nssproject.bookease.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoles, Long> {
}

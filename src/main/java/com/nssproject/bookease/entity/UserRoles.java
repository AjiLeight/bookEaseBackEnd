package com.nssproject.bookease.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
@Data
public class UserRoles {
    @Id
    private Long user_id;
    private Long role_id;
}

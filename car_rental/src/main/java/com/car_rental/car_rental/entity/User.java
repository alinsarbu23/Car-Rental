package com.car_rental.car_rental.entity;

import com.car_rental.car_rental.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}

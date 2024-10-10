package com.car_rental.car_rental.dto;

import com.car_rental.car_rental.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}

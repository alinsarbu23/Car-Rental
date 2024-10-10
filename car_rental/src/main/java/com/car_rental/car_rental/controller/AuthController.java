package com.car_rental.car_rental.controller;

import com.car_rental.car_rental.dto.SignupRequest;
import com.car_rental.car_rental.dto.UserDto;
import com.car_rental.car_rental.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupCostmer(@RequestBody SignupRequest signupRequest){

        if(authService.hasCustomerWithEmail(signupRequest.getEmail())) {
            return new ResponseEntity<>("Customer already exist with this email", HttpStatus.NOT_ACCEPTABLE);
        }


        UserDto createdCustomerDto = authService.createCustomer(signupRequest);

        if(createdCustomerDto == null) {
            return new ResponseEntity<>("Customer not created. Try again", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
    }
}

package com.car_rental.car_rental.services.auth;

import com.car_rental.car_rental.dto.UserDto;
import com.car_rental.car_rental.dto.SignupRequest;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest );

    boolean hasCustomerWithEmail(String email);
}

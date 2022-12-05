package com.example.clothessell.service;

import com.example.clothessell.dto.request.SignInForm;
import com.example.clothessell.dto.request.SignUpForm;
import com.example.clothessell.dto.response.JwtResponse;
import com.example.clothessell.dto.response.ResponseMessage;
import com.example.clothessell.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICustomerService {
    JwtResponse login(SignInForm signInForm);

    ResponseMessage register(SignUpForm signUpForm);

    List<Customer> listCus();
}

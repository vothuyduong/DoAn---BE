package com.example.clothessell.controller;

import com.example.clothessell.dto.request.SignInForm;
import com.example.clothessell.dto.request.SignUpForm;
import com.example.clothessell.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
public class AuthController {
    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignUpForm signUpForm) {
        return ResponseEntity.ok(customerService.register(signUpForm));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody SignInForm signInForm) {
        return ResponseEntity.ok(customerService.login(signInForm));
    }
}

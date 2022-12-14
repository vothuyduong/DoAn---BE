package com.example.clothessell.controller;

import com.example.clothessell.dto.request.RefreshTokenRequest;
import com.example.clothessell.dto.request.SignInForm;
import com.example.clothessell.dto.request.SignUpForm;
import com.example.clothessell.dto.request.TokenRequest;
import com.example.clothessell.dto.response.JwtResponse;
import com.example.clothessell.dto.response.ResponseMessage;
import com.example.clothessell.entity.Customer;
import com.example.clothessell.entity.RefreshToken;
import com.example.clothessell.repository.IRoleRepository;
import com.example.clothessell.security.jwt.JwtProvider;
import com.example.clothessell.security.userprincipal.UserPrinciple;
import com.example.clothessell.service.impl.CustomerServiceImpl;
import com.example.clothessell.service.impl.RefreshTokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5173")
public class AuthController {
    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RefreshTokenServiceImpl refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignUpForm signUpForm) {
        if(customerService.existsByCustomerUsername(signUpForm.getUsername())) {
            return ResponseEntity.ok(new ResponseMessage("The username is existed"));
        }

        if(customerService.existsByCustomerEmail(signUpForm.getEmail())) {
            return ResponseEntity.ok(new ResponseMessage("The email is existed"));
        }

        Customer customer = new Customer(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(), passwordEncoder.encode(signUpForm.getPassword()));

        customerService.save(customer);
        return ResponseEntity.ok(new ResponseMessage("Create success!"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        RefreshToken refreshTokenOld = refreshTokenService.findByUserId(userPrinciple.getId());
        if(refreshTokenOld != null) {
            refreshTokenService.delete(refreshTokenOld);
        }
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userPrinciple.getId());
        return ResponseEntity.ok(new JwtResponse(token, refreshToken.getToken(), userPrinciple.getUsername(), userPrinciple.getEmail(), userPrinciple.getAuthorities()));
    }
    @GetMapping("/getInfo")
    public ResponseEntity<?> getInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        RefreshToken refreshToken = refreshTokenService.findByUserId(userPrinciple.getId());
        return ResponseEntity.ok(new JwtResponse("", refreshToken.getToken(), userPrinciple.getUsername(), userPrinciple.getEmail(), userPrinciple.getAuthorities()));
    }

    @GetMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@RequestBody RefreshTokenRequest tokenRequest) {
        String requestRefreshToken = tokenRequest.getRefreshToken();
        RefreshToken refreshToken = refreshTokenService.findByToken(requestRefreshToken);
        if(refreshToken == null) {
            return ResponseEntity.ok(new ResponseMessage("Token refresh not exist!"));
        }
        Customer customer = customerService.findById(refreshToken.getUserId());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getCustomerUsername(), customer.getCustomerPassword()));
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        String token = jwtProvider.createToken(authentication);
        return ResponseEntity.ok(new JwtResponse(token, requestRefreshToken, userPrinciple.getUsername(), userPrinciple.getEmail(), userPrinciple.getAuthorities()));
    }
}

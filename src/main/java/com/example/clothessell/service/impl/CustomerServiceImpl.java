package com.example.clothessell.service.impl;

import com.example.clothessell.dto.request.SignInForm;
import com.example.clothessell.dto.request.SignUpForm;
import com.example.clothessell.dto.response.JwtResponse;
import com.example.clothessell.dto.response.ResponseMessage;
import com.example.clothessell.entity.Customer;
import com.example.clothessell.repository.ICustomerRepository;
import com.example.clothessell.repository.IRoleRepository;
import com.example.clothessell.security.jwt.JwtProvider;
import com.example.clothessell.security.userprincipal.UserPrinciple;
import com.example.clothessell.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository repository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public JwtResponse login(SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword())
        );
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return new JwtResponse(token, userPrinciple.getUsername(), userPrinciple.getEmail(), userPrinciple.getAuthorities());
    }

    @Override
    public ResponseMessage register(SignUpForm signUpForm) {
        if(repository.existsByCustomerUsername(signUpForm.getUsername())) {
            return new ResponseMessage("The username is existed");
        }

        if(repository.existsByCustomerEmail(signUpForm.getEmail())) {
            return new ResponseMessage("The email is existed");
        }

        Customer customer = new Customer(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(), passwordEncoder.encode(signUpForm.getPassword()));

        repository.save(customer);
        return new ResponseMessage("Create success!");
    }

    @Override
    public List<Customer> listCus() {
        return repository.findAll();
    }


}

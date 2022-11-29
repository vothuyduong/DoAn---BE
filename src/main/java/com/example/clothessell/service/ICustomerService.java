package com.example.clothessell.service;

import com.example.clothessell.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICustomerService {
    Customer findByCustomerUsername(String username);

    Boolean existsByCustomerUsername(String username);

    Boolean existsByCustomerEmail(String email);

    Customer save(Customer customer);

    List<Customer> getCustomers();

    Customer findById(int id);
}

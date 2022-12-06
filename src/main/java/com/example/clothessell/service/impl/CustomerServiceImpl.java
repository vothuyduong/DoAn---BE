package com.example.clothessell.service.impl;

import com.example.clothessell.entity.Customer;
import com.example.clothessell.repository.ICustomerRepository;
import com.example.clothessell.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository repository;

    @Override
    public List<Customer> listCus() {
        return repository.findAll();
    }

    @Override
    public Boolean existsByCustomerUsername(String username) {
        return repository.existsByCustomerUsername(username);
    }

    @Override
    public Boolean existsByCustomerEmail(String email) {
        return repository.existsByCustomerEmail(email);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }


}

package com.example.clothessell.service.impl;

import com.example.clothessell.dto.response.CustomerResponse;
import com.example.clothessell.entity.Customer;
import com.example.clothessell.repository.ICustomerRepository;
import com.example.clothessell.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository repository;

    @Override
    public CustomerResponse listCus(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Customer> list = repository.findAll(pageable);
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setListCustomer(list.getContent());
        customerResponse.setTotalPage(list.getTotalPages());
        customerResponse.setTotalItem(list.getTotalElements());
        return customerResponse;
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

    @Override
    public Customer findByUsername(String username) {
        return repository.findByCustomerUsername(username);
    }

    @Override
    public Customer findById(int id) {
        return repository.findById(id);
    }

}

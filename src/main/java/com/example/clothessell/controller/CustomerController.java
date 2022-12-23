package com.example.clothessell.controller;

import com.example.clothessell.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/api/customers/all")
    public ResponseEntity<?> getCustomers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        return ResponseEntity.ok(customerService.listCus(page, size));
    }

}

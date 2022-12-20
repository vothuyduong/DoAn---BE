package com.example.clothessell.controller;

import com.example.clothessell.service.impl.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://127.0.0.1:5173")
public class PriceController {

    @Autowired
    private PriceServiceImpl priceService;

    @GetMapping("/api/prices/all")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return ResponseEntity.ok(priceService.getAll(page, size));
    }
}

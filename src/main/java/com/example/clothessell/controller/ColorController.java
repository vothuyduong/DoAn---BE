package com.example.clothessell.controller;

import com.example.clothessell.repository.IColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://127.0.0.1:5173")
public class ColorController {
    @Autowired
    private IColorRepository colorRepository;

    @GetMapping("/color")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(colorRepository.findAll());
    }
}

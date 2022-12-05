package com.example.clothessell.controller;

import com.example.clothessell.dto.request.ProductForm;
import com.example.clothessell.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/api/products/all")
    public ResponseEntity<?> getAll(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                    @RequestParam(name = "size", required = false, defaultValue = "2") Integer size) {
        return ResponseEntity.ok(productService.getAll(page, size));
    }
    @PostMapping("/api/products/add")
    public ResponseEntity<?> saveProduct(@RequestBody ProductForm productForm) {
        return ResponseEntity.ok(productService.saveProduct(productForm));
    }
}

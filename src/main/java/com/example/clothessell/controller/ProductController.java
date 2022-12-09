package com.example.clothessell.controller;

import com.example.clothessell.dto.request.ProductForm;
import com.example.clothessell.dto.response.ProductInfoResponse;
import com.example.clothessell.dto.response.ProductResponse;
import com.example.clothessell.dto.response.ResponseMessage;
import com.example.clothessell.entity.Product;
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

    @GetMapping("/api/products/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/api/products/add")
    public ResponseEntity<?> saveProduct(@RequestBody ProductForm productForm) {
        Product product = productService.saveProduct(productForm);
        if(product == null) {
            new ResponseMessage("Thông tin ảnh gửi lên không đúng!");
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping("/api/products/edit")
    public ResponseEntity<?> editProduct(@RequestBody ProductInfoResponse productInfoResponse) {
        return ResponseEntity.ok(productService.updateProduct(productInfoResponse));
    }
}

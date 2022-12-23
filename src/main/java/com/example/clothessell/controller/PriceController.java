package com.example.clothessell.controller;

import com.example.clothessell.dto.response.ResponseMessage;
import com.example.clothessell.entity.ProductSize;
import com.example.clothessell.service.impl.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5173")
public class PriceController {

    @Autowired
    private PriceServiceImpl priceService;

    @GetMapping("/api/prices/all")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return ResponseEntity.ok(priceService.getAll(page, size));
    }

    @PostMapping("/api/prices/add")
    public ResponseEntity<?> saveItem(@RequestBody ProductSize productSize) {
        ProductSize pro = priceService.saveItem(productSize);
        if(pro == null) {
            return ResponseEntity.ok(new ResponseMessage("Gia da ton tai!"));
        }
        return ResponseEntity.ok(pro);
    }

    @GetMapping("/api/prices/{id}")
    public ResponseEntity<?> getItem(@PathVariable int id) {
        ProductSize pro = priceService.getInfo(id);
        if(pro == null) {
            return ResponseEntity.ok(new ResponseMessage("Chua ton tai!"));
        }
        return ResponseEntity.ok(pro);
    }

    @PostMapping("/api/prices/edit")
    public ResponseEntity<?> updateItem(@RequestBody ProductSize productSize) {
        if(priceService.updateItem(productSize) == null) {
            return ResponseEntity.ok(new ResponseMessage("Chua ton tai!"));
        }
        return ResponseEntity.ok(priceService.updateItem(productSize));
    }
}

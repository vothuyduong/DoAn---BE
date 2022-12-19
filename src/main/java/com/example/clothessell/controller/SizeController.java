package com.example.clothessell.controller;

import com.example.clothessell.dto.response.ResponseMessage;
import com.example.clothessell.dto.response.SizeResponse;
import com.example.clothessell.entity.Size;
import com.example.clothessell.service.impl.SizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5173")
public class SizeController {
    @Autowired
    private SizeServiceImpl sizeService;

    @GetMapping("/api/sizes/all")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        SizeResponse sizeResponse = sizeService.getAll(page, size);
        return ResponseEntity.ok(sizeResponse);
    }

    @PostMapping("/api/sizes/add")
    public ResponseEntity<?> addSize(@RequestBody Size size) {
        if(sizeService.findByName(size.getSizeName()) != null) {
            return ResponseEntity.ok(new ResponseMessage("Name size is exsiting!"));
        }
        return ResponseEntity.ok(sizeService.addSize(size));
    }

    @PostMapping("/api/sizes/edit")
    public ResponseEntity<?> updateSize(@RequestBody Size size) {
        if(sizeService.findByName(size.getSizeName()) != null) {
            return ResponseEntity.ok(new ResponseMessage("Name size is exsiting!"));
        }
        return ResponseEntity.ok(sizeService.updateSize(size));
    }

    @GetMapping("/api/sizes/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if(sizeService.findById(id) == null) {
            return ResponseEntity.ok(new ResponseMessage("Item not exist!"));
        }
        sizeService.delete(id);
        return ResponseEntity.ok(new ResponseMessage("Delete sucess!"));
    }

    @GetMapping("/api/size/{id}")
    public ResponseEntity<?> getItem(@PathVariable int id) {
        Size size = sizeService.findById(id);
        if(size == null) {
            return ResponseEntity.ok(new ResponseMessage("Item not exist!"));
        }
        return ResponseEntity.ok(size);
    }
}

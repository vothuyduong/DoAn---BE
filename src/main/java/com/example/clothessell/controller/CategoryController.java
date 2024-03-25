package com.example.clothessell.controller;

import com.example.clothessell.dto.response.ResponseMessage;
import com.example.clothessell.entity.Category;
import com.example.clothessell.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173/")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/api/categories/all")
    private ResponseEntity<?> getAllCategory(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "7") int size) {
        return ResponseEntity.ok(categoryService.getAll(page, size));
    }

    @GetMapping("/api/categories/{id}")
    private ResponseEntity<?> getCategory(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if(category == null) {
            return ResponseEntity.ok(new ResponseMessage("ID danh mục không tồn tại!"));
        }
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping("/api/categories/add")
    private ResponseEntity<?> saveCategory(@RequestBody Category category) {
        if(categoryService.findCategoryByName(category.getCategoryName())) {
            return ResponseEntity.ok(new ResponseMessage("Danh mục đã tồn tại!"));
        }
        Category cate = new Category(category.getCategoryName());
        return ResponseEntity.ok(categoryService.saveCategory(cate));
    }

    @PutMapping("/api/categories/update")
    private ResponseEntity<?> updateCategory(@RequestBody Category category) {
        if(categoryService.findCategoryByName(category.getCategoryName())) {
            return ResponseEntity.ok(new ResponseMessage("Danh mục đã tồn tại!"));
        }
        return ResponseEntity.ok(categoryService.updateCategory(category));
    }

    @DeleteMapping("/api/categories/delete/{id}")
    private ResponseEntity<?> deleteCategory(@PathVariable int id) {
        if(categoryService.findById(id) != null) {
            categoryService.deleteById(id);
            return ResponseEntity.ok(new ResponseMessage("Xóa thành công!"));
        }
        return ResponseEntity.ok(new ResponseMessage("Xóa thất bại!"));
    }
}

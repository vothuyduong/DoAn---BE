package com.example.clothessell.service;

import com.example.clothessell.dto.response.CategoryResponse;
import com.example.clothessell.entity.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
public interface ICategoryService {
    CategoryResponse getAll(int page, int size);

    Category saveCategory(Category category);

    Boolean findCategoryByName(String categoryName);

    Category findById(int id);

    Category updateCategory(Category category);

    void deleteById(int id);
}

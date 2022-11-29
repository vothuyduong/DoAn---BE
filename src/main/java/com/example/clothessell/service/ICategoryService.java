package com.example.clothessell.service;

import com.example.clothessell.entity.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
public interface ICategoryService {
    ArrayList<Category> getAll();

    Category saveCategory(Category category);

    Boolean findCategoryByName(String categoryName);

    Category findById(int id);

    Category updateCategory(Category category);

    void deleteById(int id);
}

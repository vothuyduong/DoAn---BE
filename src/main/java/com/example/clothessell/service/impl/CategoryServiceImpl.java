package com.example.clothessell.service.impl;

import com.example.clothessell.entity.Category;
import com.example.clothessell.repository.ICategoryRepository;
import com.example.clothessell.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public ArrayList<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Boolean findCategoryByName(String categoryName) {
        if(categoryRepository.findByCategoryName(categoryName) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category updateCategory(Category category) {
        Category old = categoryRepository.findById(category.getId());
        old.setCategoryName(category.getCategoryName());
        return categoryRepository.save(old);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}

package com.example.clothessell.service.impl;

import com.example.clothessell.dto.response.CategoryResponse;
import com.example.clothessell.entity.Category;
import com.example.clothessell.repository.ICategoryRepository;
import com.example.clothessell.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public CategoryResponse getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Category> list = categoryRepository.findAll(pageable);
        List<Category> listCategory = list.getContent();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategories(listCategory);
        categoryResponse.setTotalPage(list.getTotalPages());
        categoryResponse.setTotalItem(list.getTotalElements());
        return categoryResponse;
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

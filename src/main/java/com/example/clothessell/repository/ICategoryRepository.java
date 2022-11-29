package com.example.clothessell.repository;

import com.example.clothessell.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    ArrayList<Category> findAll();

    Category save(Category category);

    Category findByCategoryName(String categoryName);

    Category findById(int id);

    void deleteById(int id);
}

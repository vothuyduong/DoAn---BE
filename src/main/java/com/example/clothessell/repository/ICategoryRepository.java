package com.example.clothessell.repository;

import com.example.clothessell.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
   Page<Category> findAll(Pageable pageable);

    Category save(Category category);

    Category findByCategoryName(String categoryName);

    Category findById(int id);

    void deleteById(int id);
}

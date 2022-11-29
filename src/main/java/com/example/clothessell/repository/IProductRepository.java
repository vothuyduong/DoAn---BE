package com.example.clothessell.repository;

import com.example.clothessell.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product save(Product product);

    ArrayList<Product> findAll();
}

package com.example.clothessell.service;

import com.example.clothessell.entity.Product;

import java.util.ArrayList;

public interface IProductService {
    Product save(Product product);

    ArrayList<Product> getAll();
}

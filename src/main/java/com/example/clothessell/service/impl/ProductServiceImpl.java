package com.example.clothessell.service.impl;

import com.example.clothessell.entity.Product;
import com.example.clothessell.repository.IProductRepository;
import com.example.clothessell.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public ArrayList<Product> getAll() {
        return productRepository.findAll();
    }
}

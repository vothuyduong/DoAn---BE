package com.example.clothessell.service;

import com.example.clothessell.dto.request.ProductForm;
import com.example.clothessell.dto.response.ProductInfoResponse;
import com.example.clothessell.dto.response.ProductResponse;
import com.example.clothessell.entity.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
    ProductResponse getAll(Integer page, Integer size);

    List<Map<String, Object>> getAllSelect();

    ProductInfoResponse getProductById(int id);

    Product saveProduct(ProductForm productForm);

    Product updateProduct(ProductInfoResponse productInfoResponse);

}

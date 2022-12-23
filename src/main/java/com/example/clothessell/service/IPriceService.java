package com.example.clothessell.service;

import com.example.clothessell.dto.response.PriceResponse;
import com.example.clothessell.entity.ProductSize;

import java.util.Optional;

public interface IPriceService {
    PriceResponse getAll(int page, int size);

    ProductSize saveItem(ProductSize productSize);

    ProductSize getInfo(int id);

    ProductSize updateItem(ProductSize productSize);

}

package com.example.clothessell.service;

import com.example.clothessell.dto.response.PriceResponse;

public interface IPriceService {
    PriceResponse getAll(int page, int size);
}

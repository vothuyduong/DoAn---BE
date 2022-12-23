package com.example.clothessell.service;

import com.example.clothessell.dto.response.DonationResponse;

public interface IDonationService {
    DonationResponse getAll(int page, int size);
}

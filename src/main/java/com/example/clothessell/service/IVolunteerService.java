package com.example.clothessell.service;

import com.example.clothessell.dto.response.VolunteerResponse;

import java.util.Map;

public interface IVolunteerService {
    VolunteerResponse getAll(int page, int size);
}

package com.example.clothessell.service;

import com.example.clothessell.dto.response.SizeResponse;
import com.example.clothessell.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISizeService {
    SizeResponse getAll(int page, int size);

    Size addSize(Size size);

    Size findByName(String name);

    Size findById(int id);

    Size updateSize(Size size);

    void delete(int id);
}

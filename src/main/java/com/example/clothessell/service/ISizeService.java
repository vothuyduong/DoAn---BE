package com.example.clothessell.service;

import com.example.clothessell.dto.response.SizeResponse;
import com.example.clothessell.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ISizeService {
    SizeResponse getAll(int page, int size);

    List<Map<String, Object>> getAllSelect();

    Size addSize(Size size);

    Size findByName(String name);

    Size findById(int id);

    Size updateSize(Size size);

    void delete(int id);
}

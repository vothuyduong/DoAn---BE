package com.example.clothessell.service.impl;

import com.example.clothessell.dto.response.SizeResponse;
import com.example.clothessell.entity.Size;
import com.example.clothessell.repository.ISizeRepository;
import com.example.clothessell.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements ISizeService {
    @Autowired
    private ISizeRepository sizeRepository;

    @Override
    public SizeResponse getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Size> sizes = sizeRepository.findAll(pageable);
        List<Size> arrSizes = sizes.getContent();
        Long totalItem = sizes.getTotalElements();
        int totalPage = sizes.getTotalPages();

        SizeResponse sizeResponse = new SizeResponse();
        sizeResponse.setPage(totalPage);
        sizeResponse.setSize(totalItem);
        sizeResponse.setSizes(arrSizes);
        return sizeResponse;
    }

    @Override
    public Size addSize(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    public Size findByName(String name) {
        return sizeRepository.findBySizeName(name);
    }

    @Override
    public Size findById(int id) {
        return sizeRepository.findById(id);
    }

    @Override
    public Size updateSize(Size size) {
        Size sizeOld = sizeRepository.findById(size.getId());
        sizeOld.setSizeName(size.getSizeName());
        return sizeRepository.save(sizeOld);
    }

    @Override
    public void delete(int id) {
        sizeRepository.deleteById(id);
    }
}

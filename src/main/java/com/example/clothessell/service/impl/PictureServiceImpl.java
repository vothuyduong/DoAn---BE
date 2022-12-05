package com.example.clothessell.service.impl;

import com.example.clothessell.entity.Picture;

import com.example.clothessell.repository.IPictureRepository;
import com.example.clothessell.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements IPictureService {

    @Autowired
    private IPictureRepository pictureRepository;

    @Override
    public Picture save(Picture picture) {
        return pictureRepository.save(picture);
    }
}

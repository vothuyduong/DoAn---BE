package com.example.clothessell.repository;

import com.example.clothessell.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPictureRepository extends JpaRepository<Picture, Integer> {
    Picture save(Picture picture);

    List<Picture> findByProductId(int id);
}

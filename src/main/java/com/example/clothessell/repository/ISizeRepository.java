package com.example.clothessell.repository;

import com.example.clothessell.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISizeRepository extends JpaRepository<Size, Integer> {
    Page<Size> findAll(Pageable pageable);

    Size findBySizeName(String sizeName);

    Size findById(int id);
}

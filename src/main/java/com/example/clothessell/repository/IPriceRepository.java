package com.example.clothessell.repository;

import com.example.clothessell.entity.ProductSize;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriceRepository extends JpaRepository<ProductSize, Integer> {
    Page<ProductSize> findAll(Pageable pageable);

    ProductSize save(ProductSize productSize);

    ProductSize findBySizeIdAndProductId(int sizeId, int productId);

    ProductSize findById(int id);
}

package com.example.clothessell.repository;

import com.example.clothessell.entity.Donation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDonationRepository extends JpaRepository<Donation, Integer> {
    Page<Donation> findAll(Pageable pageable);
}

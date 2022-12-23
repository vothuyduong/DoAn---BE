package com.example.clothessell.repository;

import com.example.clothessell.entity.Volunteer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVolunteerRepository extends JpaRepository<Volunteer, Integer> {
    Page<Volunteer> findAll(Pageable pageable);

    Volunteer findById(int id);
}

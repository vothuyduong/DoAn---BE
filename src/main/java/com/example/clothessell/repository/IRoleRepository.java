package com.example.clothessell.repository;

import com.example.clothessell.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);

    Role findById(int id);

    ArrayList<Role> findAll();
}

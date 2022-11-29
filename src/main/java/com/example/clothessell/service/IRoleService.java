package com.example.clothessell.service;

import com.example.clothessell.entity.Role;

import java.util.ArrayList;

public interface IRoleService {
    Role findByRoleName(String roleName);

    Role findById(int id);

    ArrayList<Role> findAll();
}

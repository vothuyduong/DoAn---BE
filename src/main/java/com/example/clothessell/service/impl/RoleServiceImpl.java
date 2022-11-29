package com.example.clothessell.service.impl;

import com.example.clothessell.entity.Role;
import com.example.clothessell.repository.IRoleRepository;
import com.example.clothessell.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository repository;

    @Override
    public Role findByRoleName(String roleName) {
        return repository.findByRoleName(roleName);
    }

    @Override
    public Role findById(int id) {
        return repository.findById(id);
    }

    @Override
    public ArrayList<Role> findAll() {
        return repository.findAll();
    }
}

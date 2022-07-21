package com.example.cineflix_api.service;

import com.example.cineflix_api.entity.Roles;
import com.example.cineflix_api.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements RoleServiceImp{
    @Autowired
    RolesRepository repository;

    @Override
    public Roles getRoleByRoleId(int roleId) {
        return repository.findById(roleId).get();
    }
}

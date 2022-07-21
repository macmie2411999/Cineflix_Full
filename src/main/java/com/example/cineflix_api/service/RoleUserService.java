package com.example.cineflix_api.service;

import com.example.cineflix_api.entity.RoleUser;
import com.example.cineflix_api.repository.RoleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoleUserService implements RoleUserServiceImp{

    @Autowired
    RoleUserRepository repository;

    @Override
    public List<Map<String, ?>> getAllRoleByUserName(String username) {
        // TODO Auto-generated method stub
        return repository.getAllRoleByUsername(username);
    }

    @Override
    public List<RoleUser> getAllByUserId(long userId) {
        // TODO Auto-generated method stub
        return repository.findByIdUserId(userId);
    }
}

package com.example.cineflix_api.service;

import com.example.cineflix_api.entity.RoleUser;

import java.util.List;
import java.util.Map;

public interface RoleUserServiceImp {
    public List<Map<String,  ?>> getAllRoleByUserName(String username);
    public List<RoleUser> getAllByUserId(long userId);
}


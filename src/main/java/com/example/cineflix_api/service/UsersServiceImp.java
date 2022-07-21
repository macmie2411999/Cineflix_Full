package com.example.cineflix_api.service;

import com.example.cineflix_api.entity.Users;

public interface UsersServiceImp {
    public Users findByUsername(String username);
}

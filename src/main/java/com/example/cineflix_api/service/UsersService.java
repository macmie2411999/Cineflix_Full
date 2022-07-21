package com.example.cineflix_api.service;

import com.example.cineflix_api.entity.Users;
import com.example.cineflix_api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UsersServiceImp {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Users findByUsername(String username) {
        // TODO Auto-generated method stub
        return usersRepository.findByUsername(username);
    }
}

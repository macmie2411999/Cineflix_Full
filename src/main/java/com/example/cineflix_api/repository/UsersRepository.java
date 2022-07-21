package com.example.cineflix_api.repository;

import com.example.cineflix_api.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    public Users findByUsername(String username);
}

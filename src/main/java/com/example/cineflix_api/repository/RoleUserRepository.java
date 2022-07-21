package com.example.cineflix_api.repository;

import com.example.cineflix_api.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
//    public List<Map<String,?>> getRoleNameByUserName(String username);
//    public List<RoleUser> findByUser_id(long userId);

//    @Query(value = "call GetAllRoleByUserName(:username)", nativeQuery = true)
//    List<Map<String, ?>> getRoleNameByUserName(@Param("username") String username);
//    List<RoleUser> findByIdUserId(long userId);

    @Query(value = "call GetAllRoleByUsername(:username)", nativeQuery = true)
    List<Map<String, ?>> getAllRoleByUsername(@Param("username") String username);

    List<RoleUser> findByIdUserId(long userId);
}

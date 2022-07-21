package com.example.cineflix_api.repository;

import com.example.cineflix_api.entity.RoleUserId;
import com.example.cineflix_api.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
//    @Query(value = "call GetAllRoleByUserName(:username)", nativeQuery = true)
//    List<Map<String, ?>> getRoleNameByUserName(@Param("username") String username);

}

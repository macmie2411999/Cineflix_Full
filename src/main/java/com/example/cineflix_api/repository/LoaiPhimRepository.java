package com.example.cineflix_api.repository;

import com.example.cineflix_api.entity.LoaiPhim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiPhimRepository extends JpaRepository<LoaiPhim, Integer> {

}

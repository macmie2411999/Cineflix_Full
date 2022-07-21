package com.example.cineflix_api.repository;

import com.example.cineflix_api.entity.Phim;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Long> {
    /*JQL, Native Query */
    @Query(value="call GetAllPhimByQuocGia(:id)", nativeQuery = true)
    List<Map<String, ?>> getPhimByQuocGia(@Param("id") Integer id);

//    @Procedure("GetPhimWithCategory")
    @Query(value="call GetPhimWithCategory", nativeQuery = true)
    List<Map<String, ?>> getPhimWithCategory();
}

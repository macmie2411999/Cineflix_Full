package com.example.cineflix_api.service;

import com.example.cineflix_api.entity.LoaiPhim;
import com.example.cineflix_api.repository.LoaiPhimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoaiPhimService implements LoaiPhimServiceImp{

    @Autowired
    LoaiPhimRepository loaiPhimRepository;

    @Override
    public List<LoaiPhim> getAllLoaiPhim() {
        return loaiPhimRepository.findAll();
    }
}



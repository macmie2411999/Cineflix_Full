package com.example.cineflix_api.service;

import com.example.cineflix_api.entity.Phim;

import java.util.List;
import java.util.Map;

public interface PhimServiceImp {
    public List<Map<String, ?>> getAllPhim();
    public List<Map<String, ?>> getPhimByQuocGia(Integer id);
    public void insertPhim(Phim phim);
}

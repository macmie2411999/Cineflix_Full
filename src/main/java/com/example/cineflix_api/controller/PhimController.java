package com.example.cineflix_api.controller;

import com.example.cineflix_api.entity.Phim;
import com.example.cineflix_api.service.FileSystemStorageServiceImp;
import com.example.cineflix_api.service.PhimServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/phim")
public class PhimController {

    // LoggerFactory.getLogger(<class sets Logger>)
    Logger logger = LoggerFactory.getLogger(PhimController.class);

    @Autowired
    PhimServiceImp phimServiceImp;

    @Autowired
    FileSystemStorageServiceImp fileSystemStorageServiceImp;

    @Secured("ROLE_USER")
    @GetMapping("")
    public ResponseEntity<?> getAllPhim(){
//        logger.trace("Trace level log");
//        logger.debug("Debug level log");
        logger.info("Info level log");
        logger.warn("Warn level log");
        logger.error("Error level log");

        List<Map<String, ?>> listPhim = phimServiceImp.getAllPhim();
        return new ResponseEntity<List<Map<String, ?>>>(listPhim, HttpStatus.OK);
    }

    @GetMapping("/{id_quocgia}")
    public ResponseEntity<?> getPhimByQuocGia(@PathVariable("id_quocgia") int id_quocgia){
        List<Map<String, ?>> listPhim = phimServiceImp.getPhimByQuocGia(id_quocgia);
        return new ResponseEntity<List<Map<String, ?>>>(listPhim, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertPhim(@RequestParam("file") MultipartFile file,
                                        @RequestParam("tenphim") String tenphim,
                                        @RequestParam("mota") String mota){
//        System.out.println("kiemtra" + file.getOriginalFilename());
        fileSystemStorageServiceImp.init();
        if(fileSystemStorageServiceImp.saveFile(file)){
            Phim phim = new Phim();
            phim.setTen_phim(tenphim);
            phim.setMo_ta(mota);
            phim.setHinh_anh(file.getOriginalFilename());
            phimServiceImp.insertPhim(phim);
        }
        return new ResponseEntity<String>("", HttpStatus.OK);
    }
}

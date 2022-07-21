package com.example.cineflix_api.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service

public class FileSystemStorageService implements FileSystemStorageServiceImp {

    // File locates
    private final Path root = Paths.get("uploads");

    @Override
    public void init() {

        // Create folder to save files
        try {
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not create folder uploads");
        }

    }

    @Override
    public boolean saveFile(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can not copy file to folder uploads");
        }

    }

    @Override
    public Resource loadFile(String fileName) {
        try {
            Path path = this.root.resolve(fileName);
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Can not find files");
            }
        } catch (Exception e) {
            throw new RuntimeException("Can not find files");
        }
    }
}

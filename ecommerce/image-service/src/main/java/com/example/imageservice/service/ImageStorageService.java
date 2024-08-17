package com.example.imageservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageStorageService {

    public byte[] store(MultipartFile file) throws IOException {
        return file.getBytes();
    }
}
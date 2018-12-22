package com.springboot.onlinedealfinder.controller;

import com.springboot.onlinedealfinder.Service.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class FileController {
    private AmazonClient amazonClient;

    @Autowired
    FileController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadImage")
    @CrossOrigin(origins = "http://localhost:4200")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFileTos3bucket(file);
    }

    @DeleteMapping("/deleteFile")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
}

package com.binSeries.binFiles.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.binSeries.binFiles.file.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/binFiles")
public class FileController {
  
  @Autowired
  private FileService fileService;


  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile[] file, 
                                            @RequestParam(value="stroageType", required = false) String storageType) {
    try {
      fileService.uploadFile(file, storageType);
      return ResponseEntity.ok("File uploaded successfully");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error uploading file");
    }
      
  }
  

}

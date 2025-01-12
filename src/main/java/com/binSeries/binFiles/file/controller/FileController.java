package com.binSeries.binFiles.file.controller;

import java.util.Map;

import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.binSeries.binFiles.common.ApiResponse;
import com.binSeries.binFiles.file.service.FileService;


@RestController
@RequestMapping("/binFiles")
public class FileController {
  
  @Autowired
  private FileService fileService;


  @PostMapping("/upload")
  public ResponseEntity<ApiResponse<Map<String, Object>>> uploadFile(@RequestParam("file") MultipartFile[] file, 
                                            @RequestParam(value="stroageType", required = false) String storageType,
                                            @RequestParam(value="storagePath", required = false) String storagePath) {
      Map<String, Object> fileInfo = fileService.uploadFile(file, storageType, storagePath);
      ApiResponse<Map<String, Object>> response = new ApiResponse<>(
        HttpStatus.OK.value(),
        "File uploaded successfully",
        fileInfo
      );
     return ResponseEntity.ok(response);
  }
  

}

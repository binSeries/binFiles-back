package com.binSeries.binFiles.file.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
  
  Map<String, Object> uploadFile(MultipartFile[] file, String storageType);
}

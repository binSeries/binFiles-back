package com.binSeries.binFiles.file.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
  
  void uploadFile(MultipartFile[] file, String storageType);
}

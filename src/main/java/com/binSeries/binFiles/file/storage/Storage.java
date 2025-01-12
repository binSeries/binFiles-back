package com.binSeries.binFiles.file.storage;

import org.springframework.web.multipart.MultipartFile;

public interface Storage {
  
  void upload(MultipartFile[] file, String storagePath);
  
  void delete(String fileName);
  
  byte[] download(String fileName);
}

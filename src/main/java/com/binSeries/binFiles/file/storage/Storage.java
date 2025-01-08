package com.binSeries.binFiles.file.storage;

import org.springframework.web.multipart.MultipartFile;

public interface Storage {
  
  void upload(MultipartFile[] file);
  
  void delete(String fileName);
  
  byte[] download(String fileName);
}

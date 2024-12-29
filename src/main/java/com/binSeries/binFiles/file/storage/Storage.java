package com.binSeries.binFiles.file.storage;

public interface Storage {
  
  void upload(MultipartFile[] file);
  
  void delete(String fileName);
  
  byte[] download(String fileName);
}

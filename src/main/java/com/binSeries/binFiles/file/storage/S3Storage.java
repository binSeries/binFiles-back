package com.binSeries.binFiles.file.storage;

import org.springframework.web.multipart.MultipartFile;

import com.binSeries.binFiles.file.dto.StoragePath;

public class S3Storage implements Storage {

  @Override
  public void upload(MultipartFile[] file, String storagePath) {
     new StoragePath(S3Storage.class.getSimpleName(), storagePath);

  }

  @Override
  public void delete(String fileName) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public byte[] download(String fileName) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'download'");
  }
    
}

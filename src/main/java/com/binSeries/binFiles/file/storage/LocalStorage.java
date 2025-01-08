package com.binSeries.binFiles.file.storage;

import org.springframework.web.multipart.MultipartFile;

public class LocalStorage implements Storage {

  @Override
  public void upload(MultipartFile[] file) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'upload'");
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

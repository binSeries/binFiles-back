package com.binSeries.binFiles.file.storage;

import org.springframework.web.multipart.MultipartFile;

import com.binSeries.binFiles.exception.ErrorCode;
import com.binSeries.binFiles.exception.FileException;
import com.binSeries.binFiles.file.dto.FileInfo;
import com.binSeries.binFiles.file.dto.StoragePath;

public class LocalStorage implements Storage {

  @Override
  public void upload(MultipartFile[] file, String storagePath) {
    // storagePath를 가지고 온다
    StoragePath pathObj = new StoragePath(LocalStorage.class.getSimpleName(), storagePath);
    String realPath = pathObj.getStoragePath();

    // 폴더가 없으면 생성한다
    java.io.File folder = new java.io.File(realPath);
    if (!folder.exists()) {
        boolean created = folder.mkdirs();
        if (!created) {
            throw new FileException(ErrorCode.FILE_UPLOAD_FAILED);
        }
    }

    // 파일을 저장한다
    for (MultipartFile f : file) {
      String filePhysicalName = FileInfo.makeFilePhysicalName(f.getOriginalFilename());
      String filePath = realPath + filePhysicalName;
      try {
        f.transferTo(new java.io.File(filePath));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
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

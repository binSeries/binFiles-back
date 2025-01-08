package com.binSeries.binFiles.file.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.binSeries.binFiles.exception.ErrorCode;
import com.binSeries.binFiles.exception.FileException;
import com.binSeries.binFiles.file.storage.Storage;

@Service
public class FileServiceImpl implements FileService {

  private final Map<String, Storage> storageMap;

  // storage구현체를 모두 주입받아 맵으로 관리
  // storage구현체는 모두 spring bean으로 등록되어 있어야함
  public FileServiceImpl(List<Storage> storages) {
    this.storageMap = storages.stream()
                        .collect(Collectors.toMap(storage -> storage.getClass().getSimpleName(), storage -> storage));
  }

  // storateType에  따라서 storage주입해야함
  // storage는 aws, local, azure, google cloud 등이 있을 수 있음
  // storage는 기본적으로 인터페이스를 구현한 형태로 만들어야함
  // storage는 파일을 저장하고, 삭제하고, 다운로드하는 기능을 제공해야함


  @Override
  public Map<String, Object> uploadFile(MultipartFile[] file, String storageType) {
    HashMap<String, Object> returnMap = new HashMap<>();

    // storageType 확인 
    Storage storage = storageMap.get(storageType);
    if (storage == null) {
      throw new FileException(ErrorCode.NOT_PROVIDED_STORAGE);
    }

    // 파일 업로드
    storage.upload(file);

    return returnMap;
  }
  
}

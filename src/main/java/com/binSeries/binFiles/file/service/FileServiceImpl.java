package com.binSeries.binFiles.file.service;

import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;
import com.binSeries.binFiles.file.storage.Storage;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

  private final Map<String, Storage> storageMap;

  // storage구현체를 모두 주입받아 맵으로 관리
  public FileServiceImpl(List<Storage> storages) {
    this.storageMap = storages.stream()
                        .collect(Collectors.toMap(storage -> storage.getClass().getSimpleName(), storage -> storage));
  }

  // storateType에  따라서 storage주입해야함
  // storage는 aws, local, azure, google cloud 등이 있을 수 있음
  // storage는 기본적으로 인터페이스를 구현한 형태로 만들어야함
  // storage는 파일을 저장하고, 삭제하고, 다운로드하는 기능을 제공해야함


  @Override
  public void uploadFile(MultipartFile[] file, String storageType) {
    Storage storage = storageMap.get(storageType);
    if (storage == null) {
      throw new IllegalArgumentException("Invalid storage type");
    }

  }
  
}

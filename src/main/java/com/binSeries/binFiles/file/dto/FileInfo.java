package com.binSeries.binFiles.file.dto;

import java.util.UUID;

public class FileInfo {
  
    public static String makeFilePhysicalName(String originalName) {
        // 현재시간
        String time = System.currentTimeMillis() + "";

        // 확장자 추출
        String extension = "";
        if (originalName != null && originalName.contains(".")) {
            extension = originalName.substring(originalName.lastIndexOf("."));
        }

        // UUID 생성
        String physicalName = UUID.randomUUID().toString();


        return time + "_" + physicalName + extension;
    }
}

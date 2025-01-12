package com.binSeries.binFiles.file.dto;

import com.binSeries.binFiles.file.storage.LocalStorage;
import com.binSeries.binFiles.file.storage.R2Storage;
import com.binSeries.binFiles.file.storage.S3Storage;

public class StoragePath {
    private String storagePath;

    public StoragePath() {
        this.setLocalStoragePath();
    }

    public StoragePath(String storageType) {
        if (LocalStorage.class.getSimpleName().equals(storageType)) {
            this.setLocalStoragePath();
        } else if (S3Storage.class.getSimpleName().equals(storageType)) {
            this.setS3StoragePath();
        } else if (R2Storage.class.getSimpleName().equals(storageType)) {
            this.setR2StoragePath();
        }
    }

    public StoragePath(String storageType, String storagePath) {
        if (LocalStorage.class.getSimpleName().equals(storageType)) {
            this.setLocalStoragePath(storagePath);
        } else if (S3Storage.class.getSimpleName().equals(storageType)) {
            this.setS3StoragePath(storagePath);
        } else if (R2Storage.class.getSimpleName().equals(storageType)) {
            this.setR2StoragePath(storagePath);
        }
    }   

    
     void setLocalStoragePath() {
        this.storagePath = "C:\\binFiles\\";
    }


    private void setLocalStoragePath(String storagePath) {
        if(storagePath.trim().isEmpty()) {
            this.setLocalStoragePath();
        } else {
            this.storagePath = storagePath;
        }

    }

    private void setS3StoragePath() {
        this.storagePath = "s3://binFiles/";
    }

    private void setS3StoragePath(String storagePath) {
        if(storagePath.trim().isEmpty()) {
            this.setS3StoragePath();
        } else {
            this.storagePath = storagePath;
        }
    }

    private void setR2StoragePath() {
        this.storagePath = "r2://binFiles/";
    }

    private void setR2StoragePath(String storagePath) {
        if(storagePath.trim().isEmpty()) {
            this.setR2StoragePath();
        } else {
            this.storagePath = storagePath;
        }
    }

    public String getStoragePath() {
        return this.storagePath;
    }
}

package com.binSeries.binFiles.file.dto;

public class StoragePath {
    private String storagePath;

    StoragePath() {
        this.setLocalStoragePath();
    }

    StoragePath(String storageType) {
        if (storageType == "LocalStorage") {

        }
    }

    private void setLocalStoragePath() {
        this.storagePath = "C:\\binFiles\\";
    }

    private String getStoragePath() {
        return this.storagePath;
    }

}

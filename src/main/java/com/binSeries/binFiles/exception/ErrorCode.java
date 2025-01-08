package com.binSeries.binFiles.exception;

public enum ErrorCode {
  NOT_PROVIDED_STORAGE(400, "제공하지 않는 스토리지입니다."),
  FILE_NOT_FOUND(404, "파일을 찾을 수 없습니다."),
  FILE_UPLOAD_FAILED(500, "파일 업로드에 실패했습니다."),
  FILE_DOWNLOAD_FAILED(500, "파일 다운로드에 실패했습니다."),
  FILE_DELETE_FAILED(500, "파일 삭제에 실패했습니다."),
  INTERNAL_SERVER_ERROR(500, "서버 내부 오류가 발생했습니다.");

  private final int status;
  private final String message;

  ErrorCode(int status, String message) {
    this.status = status;
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}

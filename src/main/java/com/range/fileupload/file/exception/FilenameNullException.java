package com.range.fileupload.file.exception;

public class FilenameNullException extends RuntimeException {
  public FilenameNullException() {
    super("file name is null");
  }
}

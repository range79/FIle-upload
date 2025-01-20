package com.range.fileupload.exception;

public class DirectoryCreateException extends RuntimeException {
  public DirectoryCreateException() {
    super("Unable to create upload directory");
  }
}

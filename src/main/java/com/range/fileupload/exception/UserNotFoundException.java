package com.range.fileupload.exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String name) {
    super("Email not found: " + name);
  }
}

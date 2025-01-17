package com.range.Fileupload.Exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String name) {
    super("Email not found: " + name);
  }
}

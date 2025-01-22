package com.range.fileupload.user.exception;

public class EmailRegisteredException extends RuntimeException {
    public EmailRegisteredException() {
        super("Email already registered: " );
    }
}

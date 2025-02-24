package com.range.fileupload.exception;

public class EmailRegisteredException extends RuntimeException {
    public EmailRegisteredException() {
        super("Email already registered: " );
    }
}

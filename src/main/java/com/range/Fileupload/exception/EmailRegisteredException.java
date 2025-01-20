package com.range.Fileupload.exception;

public class EmailRegisteredException extends RuntimeException {
    public EmailRegisteredException() {
        super("Email already registered: " );
    }
}

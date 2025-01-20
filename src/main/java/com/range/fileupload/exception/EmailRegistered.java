package com.range.fileupload.exception;

public class EmailRegistered extends RuntimeException {
    public EmailRegistered() {
        super("Email already registered: " );
    }
}

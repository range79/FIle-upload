package com.range.fileupload.user.exception;

public class EmailRegistered extends RuntimeException {
    public EmailRegistered() {
        super("Email already registered: " );
    }
}

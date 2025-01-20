package com.range.Fileupload.exception;

public class EmailRegistered extends RuntimeException {
    public EmailRegistered() {
        super("Email already registered: " );
    }
}

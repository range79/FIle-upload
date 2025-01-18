package com.range.Fileupload.exception;

public class EmailNullException extends RuntimeException {
    public EmailNullException() {
        super("Email can't be null");
    }
}

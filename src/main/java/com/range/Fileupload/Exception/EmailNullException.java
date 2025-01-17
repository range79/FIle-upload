package com.range.Fileupload.Exception;

public class EmailNullException extends RuntimeException {
    public EmailNullException() {
        super("Email can't be null");
    }
}

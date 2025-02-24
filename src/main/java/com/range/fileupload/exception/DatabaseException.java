package com.range.fileupload.exception;

public class DatabaseException extends RuntimeException {
    public DatabaseException() {
        super("a database error occured");
    }
}

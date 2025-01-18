package com.range.Fileupload.exception;

public class DatabaseException extends RuntimeException {
    public DatabaseException() {
        super("a database error occured");
    }
}

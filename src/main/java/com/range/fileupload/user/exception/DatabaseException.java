package com.range.fileupload.user.exception;

public class DatabaseException extends RuntimeException {
    public DatabaseException() {
        super("a database error occured");
    }
}

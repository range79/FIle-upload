package com.range.Fileupload.Exception;

public class DatabaseException extends RuntimeException {
    public DatabaseException() {
        super("a database error occured");
    }
}

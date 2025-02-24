package com.range.fileupload.exception;

public class Filenotsaved extends RuntimeException {
    public Filenotsaved(String message) {
        super("this file can't be saved"+message);
    }
}

package com.chernyllexs.photo.api.exception;

public class FileStorageException extends RuntimeException{
    public FileStorageException() {
        super();
    }

    public FileStorageException(String message) {
        super(message);
    }
}

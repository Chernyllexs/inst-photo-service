package com.chernyllexs.photo.api.exception;

public class PhotoPostException extends RuntimeException{
    public PhotoPostException() {
        super();
    }

    public PhotoPostException(String message) {
        super(message);
    }
}

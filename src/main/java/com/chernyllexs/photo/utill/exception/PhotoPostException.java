package com.chernyllexs.photo.utill.exception;

public class PhotoPostException extends RuntimeException{
       public PhotoPostException(String message) {
        super(message);
    }

    public PhotoPostException(String message, Throwable cause) {
        super(message, cause);
    }
}

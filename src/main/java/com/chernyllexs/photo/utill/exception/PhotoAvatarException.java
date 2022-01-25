package com.chernyllexs.photo.utill.exception;

public class PhotoAvatarException extends RuntimeException{
    public PhotoAvatarException(String message) {
        super(message);
    }

    public PhotoAvatarException(String message, Throwable cause) {
        super(message, cause);
    }
}

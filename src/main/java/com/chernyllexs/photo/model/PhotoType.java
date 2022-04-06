package com.chernyllexs.photo.model;

public enum PhotoType {
    AVATAR("avatar/",300), POST("post/",1080);
    private String dir;
    private int size;

    PhotoType(String dir, int size) {
        this.dir = dir;
        this.size = size;
    }

    public String getDir() {
        return dir;
    }

    public int getSize() {
        return size;
    }
}

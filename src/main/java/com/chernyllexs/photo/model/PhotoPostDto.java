package com.chernyllexs.photo.model;

public class PhotoPostDto {
    private Long photoId;


    public PhotoPostDto() {
    }

    public PhotoPostDto(Long photoId) {
        this.photoId = photoId;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    @Override
    public String toString() {
        return "PhotoPostDto{" +
                "photoId=" + photoId +
                '}';
    }
}


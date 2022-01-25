package com.chernyllexs.photo.entity;

import javax.persistence.*;

@Entity
@Table(name = "post_photos")
public class PhotoPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_post_id")
    private Long photoId;
    private String photoName;

    public PhotoPostEntity() {
    }

    public PhotoPostEntity(Long photoId, String photoName) {
        this.photoId = photoId;
        this.photoName = photoName;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public PhotoPostEntity setPhotoId(Long photoId) {
        this.photoId = photoId;
        return this;
    }

    public String getPhotoName() {
        return photoName;
    }

    public PhotoPostEntity setPhotoName(String photoName) {
        this.photoName = photoName;
        return this;
    }

    @Override
    public String toString() {
        return "PhotoPostEntity{" +
                "photoId=" + photoId +
                ", photoName='" + photoName + '\'' +
                '}';
    }
}

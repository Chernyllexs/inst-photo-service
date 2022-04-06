package com.chernyllexs.photo.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "post_photos")
public class PhotoPostEntity {
    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "photo_post_id")
    private String photoId;


    public PhotoPostEntity() {
    }

    public PhotoPostEntity(String photoId) {
        this.photoId = photoId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoPostEntity that = (PhotoPostEntity) o;

        return getPhotoId() != null ? getPhotoId().equals(that.getPhotoId()) : that.getPhotoId() == null;
    }

    @Override
    public int hashCode() {
        return getPhotoId() != null ? getPhotoId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PhotoPostEntity{" +
                "photoId='" + photoId + '\'' +
                '}';
    }
}

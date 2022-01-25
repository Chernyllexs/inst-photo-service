package com.chernyllexs.photo.entity;

import javax.persistence.*;

@Entity
@Table(name = "avatar_photos")
public class PhotoAvatarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_avatar_id")
    private Long avatarId;
    private String photoName;
    private String userId;

    public PhotoAvatarEntity() {
    }

    public PhotoAvatarEntity(Long avatarId, String photoName, String userId) {
        this.avatarId = avatarId;
        this.photoName = photoName;
        this.userId = userId;
    }

    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AvatarPhotoEntity{" +
                "avatarId=" + avatarId +
                ", photoName='" + photoName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

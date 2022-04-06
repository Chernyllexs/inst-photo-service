package com.chernyllexs.photo.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "avatar_photos")
public class PhotoAvatarEntity {
    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "photo_avatar_id")
    private String avatarId;
//    private String photoName;
//    private String userId;

    public PhotoAvatarEntity() {
    }

    public PhotoAvatarEntity(String avatarId) {
        this.avatarId = avatarId;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoAvatarEntity that = (PhotoAvatarEntity) o;

        return getAvatarId() != null ? getAvatarId().equals(that.getAvatarId()) : that.getAvatarId() == null;
    }

    @Override
    public int hashCode() {
        return getAvatarId() != null ? getAvatarId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PhotoAvatarEntity{" +
                "avatarId='" + avatarId + '\'' +
                '}';
    }
}

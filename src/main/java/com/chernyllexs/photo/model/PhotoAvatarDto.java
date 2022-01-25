package com.chernyllexs.photo.model;

public class PhotoAvatarDto {
    private Long avatarId;

    public PhotoAvatarDto() {
    }

    public PhotoAvatarDto(Long avatarId) {
        this.avatarId = avatarId;
    }

    public Long getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Long avatarId) {
        this.avatarId = avatarId;
    }

    @Override
    public String toString() {
        return "PhotoAvatarDto{" +
                "avatarId=" + avatarId +
                '}';
    }
}

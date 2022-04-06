package com.chernyllexs.photo.api;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoAvatarService {
    void savePhoto(String id, MultipartFile file);

    byte[] getPhotoBytesById(String id);

    void deletePhoto(String id);
}

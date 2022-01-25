package com.chernyllexs.photo.service;

import com.chernyllexs.photo.model.PhotoAvatarDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoAvatarService {
    PhotoAvatarDto savePhoto(MultipartFile file);

    List<PhotoAvatarDto> getAllPhotos();

    byte[] getPhotoBytesById(Long id);

    void deletePhoto(Long id);
}

package com.chernyllexs.photo.service;

import com.chernyllexs.photo.model.PhotoPostDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoPostService {
    PhotoPostDto savePhoto(MultipartFile file);

    List<PhotoPostDto> getAllPhotos();

    byte[] getPhotoBytesById(Long id);

    void deletePhoto(Long id);
}

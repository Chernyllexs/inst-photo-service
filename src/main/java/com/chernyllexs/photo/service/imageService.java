package com.chernyllexs.photo.service;

import org.springframework.web.multipart.MultipartFile;

public interface imageService {
    public String storeFile(MultipartFile file, String contentDir);

    public void resizePostPhoto(String name, int targetSize, String contentDir);
}

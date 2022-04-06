package com.chernyllexs.photo.api;

import com.chernyllexs.photo.model.PhotoType;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ImageService {
    String storeFile(MultipartFile file, String id, PhotoType photoType) throws IOException;

    void delete(String id, PhotoType photoType);

    byte[] getPhoto(String id, PhotoType photoType) throws IOException;

}

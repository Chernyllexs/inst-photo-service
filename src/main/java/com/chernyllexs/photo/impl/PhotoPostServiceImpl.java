package com.chernyllexs.photo.impl;

import com.chernyllexs.photo.api.ImageService;
import com.chernyllexs.photo.api.PhotoPostRepository;
import com.chernyllexs.photo.api.PhotoPostService;
import com.chernyllexs.photo.api.exception.PhotoPostException;
import com.chernyllexs.photo.model.PhotoType;
import com.chernyllexs.photo.model.entity.PhotoPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class PhotoPostServiceImpl implements PhotoPostService {


    @Autowired
    private ImageService imageService;
    @Autowired
    private PhotoPostRepository photoPostRepository;


    @Override
    public void savePhoto(String id, MultipartFile file) {
        try {
            imageService.storeFile(file, id, PhotoType.POST);
        } catch (IOException e) {
            e.printStackTrace();
        }
        photoPostRepository.save(new PhotoPostEntity(id));
    }

    @Override
    public byte[] getPhotoBytesById(String id) {
        byte[] photo = new byte[0];
        photoPostRepository.findById(id).orElseThrow(
                () -> new PhotoPostException(String.format("The post photo id = %s wasn't found", id)));
        try {
            photo = imageService.getPhoto(id, PhotoType.POST);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return photo;
    }

    @Override
    @Transactional
    public void deletePhoto(String id) {
        if (photoPostRepository.deleteByPhotoId(id) != 1) {
            throw new PhotoPostException("The image wasn't deleted");
        } else {
            imageService.delete(id, PhotoType.POST);
        }
    }
}

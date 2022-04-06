package com.chernyllexs.photo.impl;

import com.chernyllexs.photo.api.ImageService;
import com.chernyllexs.photo.api.PhotoAvatarRepository;
import com.chernyllexs.photo.api.PhotoAvatarService;
import com.chernyllexs.photo.api.exception.PhotoAvatarException;
import com.chernyllexs.photo.model.PhotoType;
import com.chernyllexs.photo.model.entity.PhotoAvatarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class PhotoAvatarServiceImpl implements PhotoAvatarService {

    @Autowired
    private ImageService imageService;
    @Autowired
    private PhotoAvatarRepository photoAvatarRepository;


    @Override
    public void savePhoto(String id, MultipartFile file) {
        try {
            imageService.storeFile(file, id, PhotoType.AVATAR);
        } catch (IOException e) {
            e.printStackTrace();
        }
        photoAvatarRepository.save(new PhotoAvatarEntity(id));
    }

    @Override
    public byte[] getPhotoBytesById(String id) {
        byte[] photo = new byte[0];
        photoAvatarRepository.findById(id).orElseThrow(
                () -> new PhotoAvatarException(String.format("The avatar photo id = %s wasn't found", id)));
        try {
            photo = imageService.getPhoto(id, PhotoType.AVATAR);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return photo;
    }

    @Override
    @Transactional
    public void deletePhoto(String id) {
        if (photoAvatarRepository.deleteByAvatarId(id) != 1) {
            throw new PhotoAvatarException("The image wasn't deleted");
        } else {
            imageService.delete(id, PhotoType.AVATAR);
        }
    }
}

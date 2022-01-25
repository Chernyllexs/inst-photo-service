package com.chernyllexs.photo.service.Implementation;

import com.chernyllexs.photo.entity.PhotoAvatarEntity;
import com.chernyllexs.photo.model.PhotoAvatarDto;
import com.chernyllexs.photo.repository.PhotoAvatarRepository;
import com.chernyllexs.photo.service.PhotoAvatarService;
import com.chernyllexs.photo.utill.exception.PhotoAvatarException;
import com.chernyllexs.photo.utill.mapper.PhotoAvatarMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoAvatarServiceImpl implements PhotoAvatarService {

    private final int TARGET_SIZE_FOR_AVATAR = 300;
    private final String CONTENT_DIR_POST = "avatar\\";

    @Autowired
    private imageServiceImpl imageService;
    @Autowired
    private PhotoAvatarRepository photoAvatarRepository;
    @Autowired
    private PhotoAvatarMapper photoAvatarMapper;


    @Override
    public PhotoAvatarDto savePhoto(MultipartFile file) {
        String fileName = imageService.storeFile(file, CONTENT_DIR_POST);
        imageService.resizePostPhoto(fileName, TARGET_SIZE_FOR_AVATAR, CONTENT_DIR_POST);

        PhotoAvatarEntity photoEntity = new PhotoAvatarEntity();
        photoEntity.setPhotoName(fileName);
        photoAvatarRepository.save(photoEntity);

        return photoAvatarMapper.convertToDto(photoEntity);
    }

    @Override
    public List<PhotoAvatarDto> getAllPhotos() {
        Iterable<PhotoAvatarEntity> iterable = photoAvatarRepository.findAll();
        ArrayList<PhotoAvatarDto> photosDto = new ArrayList<>();
        for(PhotoAvatarEntity entity: iterable)
            photosDto.add(photoAvatarMapper.convertToDto(entity));
        return photosDto;
    }

    @Override
    public byte[] getPhotoBytesById(Long id) {
        byte[] bytes = new byte[0];

        PhotoAvatarEntity photoById = photoAvatarRepository.findById(id).orElseThrow(() -> new PhotoAvatarException("Avatar photo not found: id = " + id));
        try (InputStream in = new FileInputStream(new File("photo-storage\\" + CONTENT_DIR_POST + photoById.getPhotoName()))){
            bytes = IOUtils.toByteArray(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    @Override
    public void deletePhoto(Long id) {
        photoAvatarRepository.deleteById(id);
    }
}

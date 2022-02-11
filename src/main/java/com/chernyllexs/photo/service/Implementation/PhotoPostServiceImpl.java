package com.chernyllexs.photo.service.Implementation;

import com.chernyllexs.photo.entity.PhotoPostEntity;
import com.chernyllexs.photo.model.PhotoPostDto;
import com.chernyllexs.photo.repository.PhotoPostRepository;
import com.chernyllexs.photo.service.PhotoPostService;
import com.chernyllexs.photo.utill.exception.PhotoPostException;
import com.chernyllexs.photo.utill.mapper.PhotoPostMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoPostServiceImpl implements PhotoPostService {

    private final int TARGET_SIZE_FOR_POST = 1080;
    private final String CONTENT_DIR_POST = "post/";

    @Autowired
    private imageServiceImpl imageService;
    @Autowired
    private PhotoPostRepository photoPostRepository;
    @Autowired
    private PhotoPostMapper photoPostMapper;


    @Override
    public PhotoPostDto savePhoto(MultipartFile file) {
        String fileName = imageService.storeFile(file, CONTENT_DIR_POST);
        imageService.resizePostPhoto(fileName, TARGET_SIZE_FOR_POST, CONTENT_DIR_POST);

        PhotoPostEntity photoEntity = new PhotoPostEntity();
        photoEntity.setPhotoName(fileName);
        photoPostRepository.save(photoEntity);

        return photoPostMapper.convertToDto(photoEntity);
    }

    @Override
    public List<PhotoPostDto> getAllPhotos() {
        Iterable<PhotoPostEntity> iterable = photoPostRepository.findAll();
        ArrayList<PhotoPostDto> photosDto = new ArrayList<>();
        for(PhotoPostEntity entity: iterable)
            photosDto.add(photoPostMapper.convertToDto(entity));
        return photosDto;
    }

    @Override
    public byte[] getPhotoBytesById(Long id) {
        byte[] bytes = new byte[0];

        PhotoPostEntity photoById = photoPostRepository.findById(id).orElseThrow(() -> new PhotoPostException("Post photo not found: id = " + id));
        try (InputStream in = new FileInputStream(new File("/photo-storage" + CONTENT_DIR_POST + photoById.getPhotoName()))){
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
        PhotoPostEntity photoById = photoPostRepository.findById(id).orElseThrow(() -> new PhotoPostException("Post photo not found: id = " + id));
        File file = new File(photoById.getPhotoName());
        if (file.delete()) {
            System.out.println("/n/n/n/nFile deleted successfully/n/n/n/n");
        }
        photoPostRepository.deleteById(id);
    }
}

package com.chernyllexs.photo.controller;

import com.chernyllexs.photo.model.PhotoAvatarDto;
import com.chernyllexs.photo.service.Implementation.PhotoAvatarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/photo-avatar")
public class PhotoAvatarController {

    @Autowired
    private PhotoAvatarServiceImpl photoAvatarService;

    @PostMapping("/upload-img")
    public PhotoAvatarDto uploadImg(@RequestParam MultipartFile file) {
        return photoAvatarService.savePhoto(file);
    }

    @GetMapping()
    public List<PhotoAvatarDto> getPhotos() {
        return photoAvatarService.getAllPhotos();
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getPhotoById(@PathVariable Long id) {
        return photoAvatarService.getPhotoBytesById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePhotoById(@PathVariable Long id){
        photoAvatarService.deletePhoto(id);
    }
}
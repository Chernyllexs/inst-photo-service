package com.chernyllexs.photo.controller;

import com.chernyllexs.photo.model.PhotoPostDto;
import com.chernyllexs.photo.service.Implementation.PhotoPostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/photo-post")
public class PhotoPostController {

    @Autowired
    private PhotoPostServiceImpl photoPostService;

    @PostMapping("/upload-img")
    public PhotoPostDto uploadImg(@RequestParam MultipartFile file) {
        return photoPostService.savePhoto(file);
    }

    @GetMapping()
    public List<PhotoPostDto> getPhotos() {
        return photoPostService.getAllPhotos();
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getPhotoById(@PathVariable Long id) {
        return photoPostService.getPhotoBytesById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePhotoById(@PathVariable Long id){
        photoPostService.deletePhoto(id);
    }
}

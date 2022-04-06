package com.chernyllexs.photo.web.controller;

import com.chernyllexs.photo.api.PhotoPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/photo")
@CrossOrigin(origins = "*")
public class PhotoPostController {

    @Autowired
    private PhotoPostService photoPostService;

    @PostMapping("/post-upload-img")
    @RolesAllowed("user")
    public void uploadImg(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "postId") String postId) {
        photoPostService.savePhoto(postId, file);
    }

    @GetMapping(
            value = "/get-post-photo/{id}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    @ResponseBody
    public byte[] getPhotoById(@PathVariable String id) {
        return photoPostService.getPhotoBytesById(id);
    }

    @RolesAllowed("admin")
    @DeleteMapping("/delete-post-photo/{id}")
    public void deletePhotoById(@PathVariable String id) {
        photoPostService.deletePhoto(id);
    }
}

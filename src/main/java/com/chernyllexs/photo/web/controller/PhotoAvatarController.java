package com.chernyllexs.photo.web.controller;

import com.chernyllexs.photo.api.PhotoAvatarService;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
@RequestMapping("/api/photo")
@CrossOrigin(origins = "*")
public class PhotoAvatarController {

    @Autowired
    private PhotoAvatarService photoAvatarService;

    @PostMapping("/avatar-upload")
    @RolesAllowed("user")
    public void uploadImg(Principal principal, @RequestParam MultipartFile file) {
        KeycloakAuthenticationToken kp = (KeycloakAuthenticationToken) principal;
        SimpleKeycloakAccount simpleKeycloakAccount = (SimpleKeycloakAccount) kp.getDetails();
        String id = simpleKeycloakAccount.getKeycloakSecurityContext().getToken().getSubject();

        photoAvatarService.savePhoto(id, file);
    }

    @GetMapping(
            value = "/get-avatar-photo/{id}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    @ResponseBody
    public byte[] getPhotoById(@PathVariable String id) {
        return photoAvatarService.getPhotoBytesById(id);
    }

    @RolesAllowed("admin")
    @DeleteMapping("/delete-avatar-photo/{id}")
    public void deletePhotoById(@PathVariable String id) {
        photoAvatarService.deletePhoto(id);
    }
}
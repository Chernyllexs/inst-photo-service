package com.chernyllexs.photo.impl;

import com.chernyllexs.photo.api.ImageService;
import com.chernyllexs.photo.api.exception.FileStorageException;
import com.chernyllexs.photo.model.PhotoType;
import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${file.storage.upload-dir}")
    private String dir;

    @Override
    public String storeFile(MultipartFile file, String id, PhotoType type) throws IOException {
        if (file.isEmpty()) {
            throw new FileStorageException("The file is empty");
        }

        File directory = new File(dir + type.getDir());
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = dir + type.getDir() + id;

        BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        BufferedImage resizeImg = Scalr.resize(bufferedImage, type.getSize());
        ImageIO.write(resizeImg, "jpg", new File(filePath));

        return null;
    }

    @Override
    public void delete(String id, PhotoType type) {
        File file = new File(dir + type.getDir() + id);
        if (file.exists()){
            file.delete();
        }
        else
            throw new FileStorageException("The image to delete wasn't found");
    }

    @Override
    public byte[] getPhoto(String id, PhotoType type) throws IOException {
        byte[] photo = new byte[0];
        InputStream in = new FileInputStream(new File(dir + type.getDir() + id));
        photo = IOUtils.toByteArray(in);
        return photo;
    }
}

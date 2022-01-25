package com.chernyllexs.photo.service.Implementation;

import com.chernyllexs.photo.service.imageService;
import com.chernyllexs.photo.utill.exception.FileStorageException;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class imageServiceImpl implements imageService {

    @Value("${file.upload-dir}")
    private String dir;


    @Override
    public String storeFile(MultipartFile file, String contentDir) {
        String fileName = null;
        try {
            if (file.isEmpty()) {
                throw new FileStorageException("Failed to store empty file.");
            }
            Path destinationFile = Paths.get(dir + contentDir).resolve(
                    Paths.get(UUID.randomUUID() + "_" + file.getOriginalFilename()))
                    .normalize().toAbsolutePath();

            fileName = destinationFile.getFileName().toString();

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile);
            }
        } catch (IOException e) {
            throw new FileStorageException("Failed to store file.", e);
        }
        return fileName;
    }

    @Override
    public void resizePostPhoto(String name, int targetSize, String contentDir) {
        String path = dir + contentDir + name;
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(path));
            BufferedImage resizeImg = Scalr.resize(bufferedImage, targetSize);
            ImageIO.write(resizeImg, "jpg", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

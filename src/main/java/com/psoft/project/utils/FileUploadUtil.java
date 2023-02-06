package com.psoft.project.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.*;

import io.github.classgraph.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

    public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }
    public static File load(String filename, String dir){

        Path root = Paths.get(dir);
        Path file = root.resolve(filename);
        File image = new File(file.toUri());

        if (image.exists() || image.canRead()) {
            return image;
        } else {
            throw new RuntimeException("Could not read the file!");
        }
    }
}
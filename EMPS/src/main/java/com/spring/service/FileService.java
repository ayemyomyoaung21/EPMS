package com.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileService {

    @Value("${file.upload.dir:./uploads/profile-image}")
    private String uploadDir;

    @Value("${file.upload.base-url:http://localhost:8080/uploads/profile-image}")
    private String baseUrl;

    /**
     * Save profile image and return full URL
     */
    public String saveProfileImage(MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        // ✅ Validate image type
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("Only image files are allowed");
        }

        // ✅ Generate unique filename
        String extension = getFileExtension(file.getOriginalFilename());
        String filename = "profile_" + UUID.randomUUID() + extension;

        // ✅ Create directory if not exists
        Path path = Paths.get(uploadDir).normalize();
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        // ✅ Save file
        Path filePath = path.resolve(filename);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return baseUrl + "/" + filename;
    }

    /**
     * Extract file extension
     */
    private String getFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return ".jpg"; // default fallback
        }
        return filename.substring(filename.lastIndexOf("."));
    }
}
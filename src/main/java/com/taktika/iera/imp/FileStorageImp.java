package com.taktika.iera.imp;

import com.taktika.iera.config.FileStorageProperties;
import com.taktika.iera.dto.ImgB64Dto;
import com.taktika.iera.exception.FileStorageException;
import com.taktika.iera.exception.MyFileNotFoundException;
import com.taktika.iera.exception.NotFoundException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Cristian Gómez
 * cristiang.contacto@gmail.com
 */
@Service
public class FileStorageImp {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageImp(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(Long idPost, MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String[] separate = fileName.split(Pattern.quote("."));
        String ext = "." + separate[1];
        fileName = UUID.randomUUID().toString() + "-" + idPost + ext;
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) throws NotFoundException {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }

    public ImgB64Dto loadFileAsImg(String fileName) throws NotFoundException {
        ImgB64Dto objImgB64Dto = null;
        String base = null;
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            if (null != filePath) {
                byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath.toUri()));
                String encodedString = Base64.getEncoder().encodeToString(fileContent);
                base = encodedString;
                objImgB64Dto = new ImgB64Dto();
                objImgB64Dto.setImg(base);
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException | FileNotFoundException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objImgB64Dto;
    }
}

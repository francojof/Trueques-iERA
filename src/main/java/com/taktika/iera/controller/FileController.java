package com.taktika.iera.controller;

import com.taktika.iera.exception.NotFoundException;
import com.taktika.iera.imp.FileStorageImp;
import com.taktika.iera.imp.PictureImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/app/pictures")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageImp objFileStorageImp;

    @Autowired
    private PictureImp objPictureImp;

    @PostMapping("/{idPost}/uploadFile")
    public UploadFileResponse uploadFile(@PathVariable Long idPost, @RequestParam("file") MultipartFile file) throws Exception {
        String fileName = objFileStorageImp.storeFile(idPost,file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        UploadFileResponse objUploadFileResponse = new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
        if (null != objUploadFileResponse.getFileName()) {
            objPictureImp.savePictureData(idPost,objUploadFileResponse.getFileName());
        }
        return objUploadFileResponse;
    }

    /*@PostMapping("/{idPost}/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@PathVariable Long idPost, @RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> {
                    try {
                        return uploadFile(idPost, file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }*/

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws NotFoundException {
        // Load file as Resource
        Resource resource = objFileStorageImp.loadFileAsResource(fileName);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }
        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @RequestMapping(value = "images/{idPost}", method = RequestMethod.GET)
    public ResponseEntity<Object> findAllPicturesByPost(@PathVariable Long idPost) {
        ResponseEntity<Object> objResponseEntity;
        try {
            objResponseEntity = new ResponseEntity<Object>(objPictureImp.findAllPicturesByPost(idPost), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.OK);
        }
        return objResponseEntity;
    }

    @RequestMapping(value = "/{img}", method = RequestMethod.GET)
    private ResponseEntity<Object> imgBase64(@PathVariable String img) {
        ResponseEntity<Object> objResponseEntity;
        try {
            objResponseEntity = new ResponseEntity<Object>(objFileStorageImp.loadFileAsImg(img), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            objResponseEntity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return objResponseEntity;
    }


}

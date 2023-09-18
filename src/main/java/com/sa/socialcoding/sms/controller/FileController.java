package com.sa.socialcoding.sms.controller;

import com.sa.socialcoding.sms.model.File;
import com.sa.socialcoding.sms.repository.FileRepository;
import com.sa.socialcoding.sms.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

@RestController
@RequestMapping(path="/file")
public class FileController {
    @Autowired
    private FileRepository fileRepository;

    @PostMapping(path = "/upload")
    public String uploadFile(
            @RequestHeader(HttpHeaders.ACCEPT) String language,
            @RequestParam("fileName") String fileName,
            @RequestParam("fileType") String fileType,
            @RequestParam("data") MultipartFile data) throws IOException {
        File file = new File();
        file.setName(fileName);
        file.setType(fileType);
        file.setData(ImageUtil.compressImage(data.getBytes()));
        fileRepository.save(file);
        return "Saved successfully";
    }

}

package com.chaos.garden.controller;

import com.chaos.garden.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by zcfrank1st on 6/16/16.
 */
@RestController
public class UploadFileController {
    @Autowired
    private FileService fileService;

    /**
     * upload file
     * @param type 0: picture 1: video 2: resume
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity uploadFile (@RequestParam("type") int type, @RequestParam("file")MultipartFile file) throws IOException {
        fileService.uploadFile(file, type);
        return ResponseEntity.ok().build();
    }
}

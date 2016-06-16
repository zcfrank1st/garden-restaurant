package com.chaos.garden.service;

import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by zcfrank1st on 6/14/16.
 */
@Service
@Slf4j
public class FileService {
    @Autowired
    private Config config;

    public void uploadFile (MultipartFile file, int type) throws IOException {
        String filename = file.getOriginalFilename();

        String directory = "";
        if (0 == type) {
            directory = config.getString("file.picture.path");
        } else if (1 == type) {
            directory = config.getString("file.video.path");
        } else if (2 == type) {
            directory = config.getString("file.resume.path");
        }

        String filepath = Paths.get(directory, DigestUtils.md2Hex(filename)).toString();

        BufferedOutputStream stream = null;
        try {
            stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(file.getBytes());
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
}

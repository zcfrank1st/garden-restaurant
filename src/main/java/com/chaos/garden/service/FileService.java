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
    private static final String PIC_URL = "http://static.szechuangarden1986.com/pics";
    private static final String VIDEO_URL = "http://static.szechuangarden1986.com/vodeos";
    private static final String RESUME_URL = "http://static.szechuangarden1986.com/resumes";

    @Autowired
    private Config config;

    public String uploadFile (MultipartFile file, int type) throws IOException {
        String filename = file.getOriginalFilename();

        String directory = "";
        String urlPrefix = "";
        if (0 == type) {
            directory = config.getString("file.picture.path");
            urlPrefix = PIC_URL;
        } else if (1 == type) {
            directory = config.getString("file.video.path");
            urlPrefix = VIDEO_URL;
        } else if (2 == type) {
            directory = config.getString("file.resume.path");
            urlPrefix = RESUME_URL;
        }

        String encodeFileName;
        if (filename.contains(".")) {
            String[] filenameArray = filename.split("\\.");
            encodeFileName = DigestUtils.md2Hex(filename) + "." + filenameArray[filenameArray.length - 1];
        } else {
            encodeFileName = DigestUtils.md2Hex(filename);
        }
        BufferedOutputStream stream = null;
        try {
            stream = new BufferedOutputStream(new FileOutputStream(new File(Paths.get(directory, encodeFileName).toString())));
            stream.write(file.getBytes());
            return urlPrefix + "/" + encodeFileName;
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
}

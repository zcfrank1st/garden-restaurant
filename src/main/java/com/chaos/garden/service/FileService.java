//package com.chaos.garden.service;
//
//import com.dropbox.core.DbxAuthInfo;
//import com.dropbox.core.DbxException;
//import com.dropbox.core.DbxRequestConfig;
//import com.dropbox.core.json.JsonReader;
//import com.dropbox.core.v2.DbxClientV2;
//import com.dropbox.core.v2.files.FileMetadata;
//import com.dropbox.core.v2.files.WriteMode;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.io.*;
//import java.util.Date;
//
///**
// * Created by zcfrank1st on 6/14/16.
// */
//@Service
//@Slf4j
//public class FileService {
//    private DbxAuthInfo authInfo = null;
//
//    public FileService () throws JsonReader.FileLoadException {
//        authInfo = DbxAuthInfo.Reader.readFromFile("");
//    }
//
//    public void uploadFile (File file, String targetPath) throws JsonReader.FileLoadException, IOException, DbxException {
//        DbxRequestConfig requestConfig = new DbxRequestConfig("upload-file");
//        DbxClientV2 dbxClient = new DbxClientV2(requestConfig, authInfo.getAccessToken(), authInfo.getHost());
//        try (InputStream in = new FileInputStream(file)) {
//            dbxClient.files().uploadBuilder(targetPath)
//                    .withMode(WriteMode.ADD)
//                    .withClientModified(new Date(file.lastModified()))
//                    .uploadAndFinish(in);
//        }
//
//    }
//
//    public void downloadFile () {}
//}

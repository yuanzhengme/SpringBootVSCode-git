package com.yuanzheng.springbootvscode.filecontroller;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class FileDownloadController {
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> downloadFile() throws IOException {
        String filePath = "D:\\Java_Visual Studio Code\\springbootvscode\\test_git.txt";
        File file = new File(filePath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment;filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/txt")).body(resource);
        return responseEntity;
    }

}
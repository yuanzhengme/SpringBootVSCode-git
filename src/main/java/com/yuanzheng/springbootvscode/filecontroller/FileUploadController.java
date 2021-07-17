package com.yuanzheng.springbootvscode.filecontroller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FileUploadController {
    @PostMapping(value = "/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file) throws Exception {
        File convertFile = new File(file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return "File is upload successfully!";
    }

}
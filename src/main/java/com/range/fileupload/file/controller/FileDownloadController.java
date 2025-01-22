package com.range.fileupload.file.controller;

import com.range.fileupload.file.model.MyFile;
import com.range.fileupload.file.service.impl.FileDownloadServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FileDownloadController {

    private final FileDownloadServiceImpl fileDownloadServiceImpl;

    public FileDownloadController(FileDownloadServiceImpl fileDownloadServiceImpl) {
        this.fileDownloadServiceImpl = fileDownloadServiceImpl;
    }

    @GetMapping("/file-download/")
    public ResponseEntity<byte[]> download(@RequestParam(name = "filename") String filename) {
        MyFile file = fileDownloadServiceImpl.downloadFile(filename);

        if (file == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"");
        return new ResponseEntity<>(file.getData(), headers, HttpStatus.OK);
    }
}







package com.range.fileupload.controller.impl;

import com.range.fileupload.controller.FileDownloadController;
import com.range.fileupload.service.FileDownloadService;
import com.range.fileupload.service.impl.FileDownloadServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;

import static org.springframework.security.config.Elements.HEADERS;

@Controller
public class FileDownloadControllerImpl implements FileDownloadController {

    private final FileDownloadServiceImpl fileDownloadServiceImpl;
    private final FileDownloadService fileDownloadService;

    public FileDownloadControllerImpl(FileDownloadServiceImpl fileDownloadServiceImpl, FileDownloadService fileDownloadService) {
        this.fileDownloadServiceImpl = fileDownloadServiceImpl;
        this.fileDownloadService = fileDownloadService;
    }
    @Override
    @GetMapping("/file-download/")
    public ResponseEntity<byte[]> download(@RequestParam("filename") String filename) throws FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", filename);
return ResponseEntity.ok().headers(headers).body(fileDownloadService.downloadFile(filename));



    }
}







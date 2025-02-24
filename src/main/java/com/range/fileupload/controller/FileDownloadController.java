package com.range.fileupload.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;

public interface FileDownloadController {
    ResponseEntity<byte[]> download(@RequestParam(name = "filename") String filename) throws FileNotFoundException;

}

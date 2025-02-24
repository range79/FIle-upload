package com.range.fileupload.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadController {
    String FileUpload(Model model);
    String FileUploadPost(@RequestParam("file") MultipartFile file);
}

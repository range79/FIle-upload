package com.range.fileupload.service;

import com.range.fileupload.model.MyFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {
    MyFile uploadFile(MultipartFile file, String author);
    List<String> getallfiles();
}

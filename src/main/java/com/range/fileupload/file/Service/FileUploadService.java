package com.range.fileupload.file.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {
    String uploadFile(MultipartFile file,String author);
    List<String> getallfiles();
}

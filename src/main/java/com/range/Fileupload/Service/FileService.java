package com.range.Fileupload.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    String uploadFile(MultipartFile file,String author);
    List<String> getallfiles();
}

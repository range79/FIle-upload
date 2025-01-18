package com.range.Fileupload.Service.impl;

import com.range.Fileupload.Service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    List<String>uploadFileList=new ArrayList<>();
    private final String fileUploaddir= "upload/";
    @Override
    public String uploadFile(MultipartFile file,String author) {
        if (file.isEmpty()) {
            return "ur file is empty";
        }
        try{
            File uploaddirectory=new File(fileUploaddir);
            if(!uploaddirectory.exists()) {
                uploaddirectory.mkdir();

            }
            uploadFileList.add(file.getOriginalFilename()+" from "+author);
            return "FILE UPLOAD SUCCESS";
    } catch (Exception e) {
            return "FILE UPLOAD FAIL";
        }



    }

    @Override
    public List<String> getallfiles() {
        return uploadFileList;
    }
}

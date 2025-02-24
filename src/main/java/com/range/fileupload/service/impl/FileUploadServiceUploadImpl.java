package com.range.fileupload.service.impl;

import com.range.fileupload.exception.Filenotsaved;
import com.range.fileupload.mapper.FileMapper;
import com.range.fileupload.model.MyFile;
import com.range.fileupload.filerepo.FileRepository;
import com.range.fileupload.userRepo.UserRepository;
import com.range.fileupload.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileUploadServiceUploadImpl implements FileUploadService {

    private final String fileUploaddir = System.getProperty("user.dir") + "/upload/";
    private FileRepository fIleRepository;
    private UserRepository userRepository;

    public FileUploadServiceUploadImpl(FileRepository fIleRepository, UserRepository userRepository) {
        this.fIleRepository = fIleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public MyFile uploadFile(MultipartFile file, String author) {
        if (file.isEmpty()) {
          throw new Filenotsaved("file is empty");
        }
        try {
           MyFile myFile = new MyFile();
           myFile.setFileName(file.getOriginalFilename());
           myFile.setFileType(file.getContentType());
           myFile.setFileData(file.getBytes());
            return fIleRepository.save(myFile);
    } catch (IOException e) {
            throw new Filenotsaved(e.getMessage());
        }

    }

    @Override
    public List<String> getallfiles() {
        List<MyFile> files = fIleRepository.findAll();
        FileMapper fileMapper=new FileMapper();
        return fileMapper.getFilesname(files);
    }
}

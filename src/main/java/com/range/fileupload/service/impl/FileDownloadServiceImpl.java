package com.range.fileupload.service.impl;

import com.range.fileupload.model.MyFile;
import com.range.fileupload.filerepo.FileRepository;
import com.range.fileupload.userRepo.UserRepository;
import com.range.fileupload.service.FileDownloadService;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class FileDownloadServiceImpl implements FileDownloadService {
    String filepath = System.getProperty("user.dir") + "/upload/";
    private final UserRepository userRepository;
    private FileRepository fIleRepository;

    public FileDownloadServiceImpl(FileRepository fIleRepository, UserRepository userRepository) {
        this.fIleRepository = fIleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public byte[] downloadFile(String fileName) throws FileNotFoundException {


        MyFile fileRecord = fIleRepository.getMyFileByFileName(fileName);
        if (fileRecord == null) {
            throw new FileNotFoundException("File not found in the database");
        }


        return fileRecord.getFileData();
    }
}

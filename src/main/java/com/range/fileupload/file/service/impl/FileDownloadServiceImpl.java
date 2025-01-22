package com.range.fileupload.file.service.impl;

import com.range.fileupload.file.exception.FilenameNullException;
import com.range.fileupload.file.repo.FIleRepository;
import com.range.fileupload.file.service.FileDownloadService;
import com.range.fileupload.file.model.MyFile;
import com.range.fileupload.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileDownloadServiceImpl implements FileDownloadService {
    String filepath = System.getProperty("user.dir") + "/upload/";
    private final UserRepository userRepository;
    private FIleRepository fIleRepository;

    public FileDownloadServiceImpl(FIleRepository fIleRepository, UserRepository userRepository) {
        this.fIleRepository = fIleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public MyFile downloadFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new FilenameNullException();
        }

        MyFile fileRecord = fIleRepository.getFileByFileName(fileName);
        if (fileRecord == null) {
            throw new RuntimeException("File not found in the database");
        }

        File fileOnDisk = new File(filepath + fileName);
        if (!fileOnDisk.exists()) {
            throw new RuntimeException("File not found on the disk");
        }

        try {
            byte[] fileData = Files.readAllBytes(Path.of(fileOnDisk.getPath()));
            fileRecord.setData(fileData);
            return fileRecord;
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while reading file from disk", e);
        }
    }
}

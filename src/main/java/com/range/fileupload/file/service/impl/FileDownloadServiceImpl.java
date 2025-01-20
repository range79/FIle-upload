package com.range.fileupload.file.service.impl;

import com.range.fileupload.file.repo.FIleRepository;
import com.range.fileupload.file.service.FileDownloadService;
import com.range.fileupload.file.model.MyFile;
import org.springframework.stereotype.Service;

@Service
public class FileDownloadServiceImpl implements FileDownloadService {

    private FIleRepository fIleRepository;

    public FileDownloadServiceImpl(FIleRepository fIleRepository) {
        this.fIleRepository = fIleRepository;

    }


    @Override
    public MyFile downloadFile(String fileName) {
        return fIleRepository.getFileByFileName(fileName);
    }
}

package com.range.fileupload.file.service.impl;

import com.range.fileupload.file.mapper.FileMapper;
import com.range.fileupload.file.repo.FIleRepository;
import com.range.fileupload.user.repository.UserRepository;
import com.range.fileupload.file.service.FileUploadService;
import com.range.fileupload.file.model.MyFile;
import com.range.fileupload.user.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class FileUploadServiceUploadImpl implements FileUploadService {

    private final String fileUploaddir = System.getProperty("user.dir") + "/upload/";
    private FIleRepository fIleRepository;
    private UserRepository userRepository;

    public FileUploadServiceUploadImpl(FIleRepository fIleRepository, UserRepository userRepository) {
        this.fIleRepository = fIleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String uploadFile(MultipartFile file, String author) {
        if (file.isEmpty()) {
            return "File is empty";
        }
        try {
            // Ensure upload directory exists
            File uploadDirectory = new File(fileUploaddir);
            if (!uploadDirectory.exists()) {
                if (!uploadDirectory.mkdir()) {
                    return "Failed to create the upload directory";
                }
            }

            // Make the file name unique by appending timestamp
            String uniqueFileName = file.getOriginalFilename() + "_from_" + author + "_" + System.currentTimeMillis();

            // Target file
            File uploadedFile = new File(uploadDirectory, uniqueFileName);

            // Save file to upload directory
            file.transferTo(uploadedFile);

            // Retrieve user by author
            User user = userRepository.findByUsername(author);
            if (user == null) {
                return "User not found";
            }

            MyFile myFile = new MyFile();
            myFile.setFileName(file.getOriginalFilename());
            myFile.setData(file.getBytes());
            myFile.setUser(user);

            // Save file information in the database
            fIleRepository.save(myFile);

            return "File uploaded successfully";
        } catch (Exception e) {
            // Consider replacing with a logging framework
            System.out.println("Failed to upload file: " + e.getMessage());
            return "Failed to upload file";
        }
    }

    @Override
    public List<String> getallfiles() {
        List<MyFile> files = fIleRepository.findAll();
        FileMapper fileMapper=new FileMapper();
        return fileMapper.getFilesname(files);
    }
}

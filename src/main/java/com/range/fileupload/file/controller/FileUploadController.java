package com.range.fileupload.file.controller;

import com.range.fileupload.file.service.impl.FileUploadServiceUploadImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
    private final FileUploadServiceUploadImpl fileServiceimpl;
    public FileUploadController(FileUploadServiceUploadImpl fileServiceimplUpload) {
        this.fileServiceimpl = fileServiceimplUpload;
    }
    @GetMapping("/file-upload")
    public String FileUpload(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("username",name);
        model.addAttribute("uploadedFiles",fileServiceimpl.getallfiles());
        return "Upload";
    }
    @PostMapping("/file-upload")
    public String FileUploadPost(@RequestParam("file") MultipartFile file){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
    fileServiceimpl.uploadFile(file,name);
    return "redirect:/file-upload";
    }
}

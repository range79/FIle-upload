package com.range.Fileupload.controller;

import com.range.Fileupload.Service.FileService;
import com.range.Fileupload.Service.impl.FileServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
    private final FileServiceImpl fileServiceimpl;
    public FileController(FileServiceImpl fileServiceimpl) {
        this.fileServiceimpl = fileServiceimpl;
    }
    @GetMapping("/File-upload")
    public String FileUpload(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("username",name);
        model.addAttribute("uploadedFiles",fileServiceimpl.getallfiles());
        return "Upload";
    }
    @PostMapping("/File-upload")
    public String FileUploadPost(@RequestParam("file") MultipartFile file){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
    fileServiceimpl.uploadFile(file,name);
    return "redirect:/File-upload";
    }
}

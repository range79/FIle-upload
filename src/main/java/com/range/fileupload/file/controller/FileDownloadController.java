package com.range.fileupload.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FileDownloadController {
    @GetMapping("/download/{filename}")
    public String download(@PathVariable String filename){
        return "";
    }


}







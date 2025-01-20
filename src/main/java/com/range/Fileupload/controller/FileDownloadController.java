package com.range.Fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FileDownloadController {
    @GetMapping("/Download/{fioname}")
    public String download(@PathVariable String filename){
        return "";
    }


}







package com.range.Fileupload.Controller;

import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FileController {
@GetMapping("/File-upload")
public String FileUpload(Model model){

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String name = auth.getName();
    model.addAttribute("username",name);
    return "Upload";


}
}

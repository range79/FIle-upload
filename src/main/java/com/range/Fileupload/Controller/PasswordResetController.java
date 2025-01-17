package com.range.Fileupload.Controller;

import com.range.Fileupload.DTO.ResetPasswordDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PasswordResetController {

    @GetMapping("/forgot-password")
    public String forgot(Model model){
        model.addAttribute("resetPasswordDto", new ResetPasswordDto());
        return "password-forget";
    }




}

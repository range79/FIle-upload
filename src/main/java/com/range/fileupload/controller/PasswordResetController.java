package com.range.fileupload.controller;

import com.range.fileupload.dto.ResetPasswordDto;
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

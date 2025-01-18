package com.range.Fileupload.controller;

import com.range.Fileupload.dto.ResetPasswordDto;
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

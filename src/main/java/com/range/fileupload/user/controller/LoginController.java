package com.range.fileupload.user.controller;

import com.range.fileupload.user.service.Impl.LoginServiceImpl;
import com.range.fileupload.user.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class LoginController  {

    private final LoginServiceImpl loginServiceImpl;

    public LoginController(LoginServiceImpl loginServiceImpl){
        this.loginServiceImpl=loginServiceImpl;
    }

    @GetMapping("/login")
    public String showloginform(Model model){
        model.addAttribute("userDTO",new UserDTO());
        return "login";
    }
    @PostMapping("/login")
    public String loginController(@ModelAttribute("userDTO") UserDTO userDTO, Model model) throws InterruptedException {

        try {
            boolean authenticated = loginServiceImpl.authenticate(userDTO.getEmail(), userDTO.getPassword());
            if (authenticated) {
                return "redirect:/file-upload";  // Anasayfaya yönlendir
            } else {
                model.addAttribute("error", "Geçersiz e-posta veya şifre.");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Bir hata oluştu: " + e.getMessage());
            return "login";
        }
        }

    }





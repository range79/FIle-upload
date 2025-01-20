package com.range.Fileupload.controller;

import com.range.Fileupload.dto.UserDTO;
import com.range.Fileupload.Service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class LoginController  {

    private final UserServiceImpl userServiceImpl;

    public LoginController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/login")
    public String showloginform(Model model){
        model.addAttribute("userDTO",new UserDTO());
        return "login";
    }
    @PostMapping("/login")
    public String loginController(@ModelAttribute("userDTO") UserDTO userDTO, Model model) throws InterruptedException {

        try {
            boolean authenticated = userServiceImpl.authenticate(userDTO.getEmail(), userDTO.getPassword());
            if (authenticated) {
                return "redirect:/File-upload";  // Anasayfaya yönlendir
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





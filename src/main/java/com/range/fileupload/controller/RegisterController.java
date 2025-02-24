package com.range.fileupload.controller;

import com.range.fileupload.dto.UserDTO;
import com.range.fileupload.service.impl.RegisterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class RegisterController {

    private final RegisterServiceImpl registerServiceImpl;
    public RegisterController(RegisterServiceImpl registerServiceImpl) {
      this.registerServiceImpl = registerServiceImpl;
    }



    @GetMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("user", new UserDTO());
        return "register";
    }
    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("user") UserDTO userDTO, Model model){
        try{
this.registerServiceImpl.register(userDTO);
model.addAttribute("successMessage","Register Success");

return "login";
        }catch (Exception e){
            model.addAttribute("errorMessage",e.getMessage());
            System.out.println(e.getMessage());
        return "register";
        }

    }
}

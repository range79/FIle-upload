package com.range.Fileupload.Controller;

import com.range.Fileupload.DTO.UserDTO;
import com.range.Fileupload.Service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class RegisterController {

    private final UserServiceImpl userServiceIMPL;
    public RegisterController(UserServiceImpl userServiceIMPL) {
      this.userServiceIMPL = userServiceIMPL;
    }


    @GetMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("user", new UserDTO());
        return "register";
    }
    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("user") UserDTO userDTO, Model model){
        try{
this.userServiceIMPL.register(userDTO);
model.addAttribute("successMessage","Register Success");

return "login";
        }catch (Exception e){
            model.addAttribute("errorMessage",e.getMessage());
            System.out.println(e.getMessage());
        return "register";
        }

    }
}

package com.range.fileupload.user.service.Impl;

import com.range.fileupload.config.MYPasswordEncoder;
import com.range.fileupload.user.dto.UserDTO;
import com.range.fileupload.exception.DatabaseException;
import com.range.fileupload.exception.EmailRegisteredException;
import com.range.fileupload.user.model.Role;
import com.range.fileupload.user.model.User;
import com.range.fileupload.user.repository.UserRepository;
import com.range.fileupload.user.service.RegisterService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {


    private final UserRepository userRepository;
    private final MYPasswordEncoder myPasswordEncoder;
    public RegisterServiceImpl(UserRepository userRepository, MYPasswordEncoder myPasswordEncoder) {
        this.userRepository = userRepository;
       this.myPasswordEncoder = myPasswordEncoder;
    }

    @Override

    public String register(UserDTO userDTO) {
        try{
          UserDetails searchUser=  userRepository.findByEmail(userDTO.getEmail());
//User user = userRepository.findByUsername(userDTO)

          if(searchUser!=null){
throw new EmailRegisteredException();
          }
            User user = new User();
            user.setEmail(userDTO.getEmail());
            user.setUsername(userDTO.getUsername());
            user.setPassword(myPasswordEncoder.getPasswordEncoder().encode(userDTO.getPassword()));
            user.setRole(Role.User);
            userRepository.save(user);
            return "success";
        }
        catch (Exception e){
            throw new DatabaseException();
        }
    }


}

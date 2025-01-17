package com.range.Fileupload.Service.impl;

import com.range.Fileupload.Config.MYPasswordEncoder;
import com.range.Fileupload.DTO.UserDTO;
import com.range.Fileupload.Exception.DatabaseException;
import com.range.Fileupload.Exception.UserNotFoundException;
import com.range.Fileupload.Model.Role;
import com.range.Fileupload.Model.User;
import com.range.Fileupload.Repo.UserRepository;
import com.range.Fileupload.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final MYPasswordEncoder myPasswordEncoder;
    public UserServiceImpl(UserRepository userRepository, MYPasswordEncoder myPasswordEncoder) {
        this.userRepository = userRepository;
       this.myPasswordEncoder = myPasswordEncoder;
    }

    @Override

    public String register(UserDTO userDTO) {
        try{
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

    @Override
    public boolean authenticate(String email, String password) {

           UserDetails user = userRepository.findByEmail(email);
           if(user==null){
               throw new UserNotFoundException(email);

           }
           else if(!myPasswordEncoder.getPasswordEncoder().encode(password).matches(user.getPassword())){
               return true;
           }
           else{ return false;}


        }
}

package com.range.fileupload.user.service.Impl;

import com.range.fileupload.user.repository.UserRepository;
import com.range.fileupload.user.service.LoginService;
import com.range.fileupload.config.MYPasswordEncoder;
import com.range.fileupload.exception.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;
    private final MYPasswordEncoder myPasswordEncoder;
    public LoginServiceImpl(UserRepository userRepository, MYPasswordEncoder myPasswordEncoder) {
        this.userRepository = userRepository;
        this.myPasswordEncoder = myPasswordEncoder;
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

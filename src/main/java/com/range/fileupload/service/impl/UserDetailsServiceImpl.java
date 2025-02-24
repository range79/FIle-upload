package com.range.fileupload.service.impl;

import com.range.fileupload.exception.UserNotFoundException;
import com.range.fileupload.userRepo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

private UserRepository userRepository;
public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
}
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if(email.isEmpty()){
          throw new UserNotFoundException("Email is not found");
        }
      return  userRepository.findByEmail(email);
    }
}

package com.range.fileupload.user.service.Impl;

import com.range.fileupload.exception.EmailNullException;
import com.range.fileupload.user.Repository.UserRepository;
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
          throw new EmailNullException();
        }
      return  userRepository.findByEmail(email);
    }
}

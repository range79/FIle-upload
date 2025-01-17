package com.range.Fileupload.Service.impl;

import com.range.Fileupload.Exception.EmailNullException;
import com.range.Fileupload.Repo.UserRepository;
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

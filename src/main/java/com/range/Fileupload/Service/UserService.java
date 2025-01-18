package com.range.Fileupload.Service;

import com.range.Fileupload.dto.UserDTO;

public interface UserService {

    String register(UserDTO userDTO);
    boolean authenticate(String email, String password);



}
package com.range.fileupload.userRepo;

import com.range.fileupload.exception.UserNotFoundException;
import com.range.fileupload.model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(@Email String email)throws UserNotFoundException;
    User findByUsername(String username)throws UserNotFoundException;
}

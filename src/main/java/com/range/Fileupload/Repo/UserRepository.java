package com.range.Fileupload.Repo;

import com.range.Fileupload.exception.UserNotFoundException;
import com.range.Fileupload.model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(@Email String email)throws UserNotFoundException;
    User findByUsername(String username)throws UserNotFoundException;
}

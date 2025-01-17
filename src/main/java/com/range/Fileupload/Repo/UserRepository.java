package com.range.Fileupload.Repo;

import com.range.Fileupload.Exception.UserNotFoundException;
import com.range.Fileupload.Model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(@Email String email)throws UserNotFoundException;
}

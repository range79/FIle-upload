package com.range.fileupload.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class ResetPasswordDto {
    @NotEmpty(message = "Email can't be blank")
    @Email(message = "Please enter a valid email address.")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

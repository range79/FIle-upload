package com.range.fileupload.user.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    Admin,User,Moderator;

    @Override
    public String getAuthority() {
        return name();
    }
}

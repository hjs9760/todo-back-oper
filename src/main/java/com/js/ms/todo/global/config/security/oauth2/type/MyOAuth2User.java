package com.js.ms.todo.global.config.security.oauth2.type;

import com.js.ms.todo.domain.member.domain.Role;
import org.springframework.security.oauth2.core.user.OAuth2User;


public abstract class MyOAuth2User implements OAuth2User {

    public Long dbPK;
    public String email;
    public Role role;

}

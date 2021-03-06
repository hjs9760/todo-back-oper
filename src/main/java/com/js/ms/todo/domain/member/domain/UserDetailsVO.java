package com.js.ms.todo.domain.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
@Getter
public class UserDetailsVO implements UserDetails {

    private Member member;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsVO(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return member.getPw();
    }

    @Override
    public String getUsername() {
        return member.getName();
    }


    @Override
    // 계정이 만료되었는지 (true = 만료되지 않음)
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    // 계정이 잠겨 있는지 (true = 계정이 잠겨있지 않음)
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    // 계정의 암호가 만료돠었는지 (true = 만료되지 않음)
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    // 계정이 사용가능 한지(true = 사용가능한 계정)
    public boolean isEnabled() {
        return false;
    }

}
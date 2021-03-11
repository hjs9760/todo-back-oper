package com.js.ms.todo.domain.member.presentation.dto;

import com.js.ms.todo.domain.member.domain.Role;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class UserInfo {
    
    private String userId;

    private String name;

    private Role role;

    private LocalDate birth;

    private String gender;

    private String profileImage;

    private String email;

    private String jwt;
}

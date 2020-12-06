package com.js.ms.todo.domain.member.domain;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long idx;

    @Column
    private String id;

    @Column
    private String pw;

    @Column
    private String name;

    @Column
    private String providerName;

    @Column
    private String accessToken;

    @Column
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    @Column
    @Builder.Default private Role role = Role.ROLE_USER;

    @Column
    private Integer Age;

    @Column
    private String gender;





}

package com.example.toyproject.domain.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class MemberDto {

    private String name;
    private String password;
    private String phoneNumber;
    private String nickname;
    private String email;
    private Role role;


    public Member toEntity(){
        return Member.builder()
                .name(this.name)
                .password(this.password)
                .nickname(this.nickname)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .role(this.role)
                .build();
    }
}

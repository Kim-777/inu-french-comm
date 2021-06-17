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
    private String nickName;
    private String eMail;
    private Role role;


    public Member toEntity(){
        return Member.builder()
                .name(this.name)
                .password(this.password)
                .nickName(this.nickName)
                .phoneNumber(this.phoneNumber)
                .eMail(this.eMail)
                .role(this.role)
                .build();
    }
}

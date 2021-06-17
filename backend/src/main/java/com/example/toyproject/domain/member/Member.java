package com.example.toyproject.domain.member;

import com.example.toyproject.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String eMail;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name= "board_id")
    private Board board;


    // 생년월일 추가해보고싶다

    @Builder
    public Member(String name, String password, String phoneNumber, String nickName, Role role, String eMail){
        this.name = name;
        this.password= password;
        this.phoneNumber = phoneNumber;
        this.nickName = nickName;
        this.role = role;
        this.eMail=  eMail;
    }
}

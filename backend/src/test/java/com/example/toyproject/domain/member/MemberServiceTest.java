package com.example.toyproject.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void 회원가입(){
        //given
        String name = "모수혁";
        String password = "a123456789";
        String phoneNumber = "010-1234-5678";
        String nickName = "Suhyeokeee";
        String email = "msv31v@likelion.org";
        MemberDto memberDto = new MemberDto();
        memberDto.setName(name);
        memberDto.setNickname(nickName);
        memberDto.setPassword(passwordEncoder.encode(password));
        memberDto.setPhoneNumber(phoneNumber);
        memberDto.setEmail(email);
        Member member = memberDto.toEntity();
        // when
        memberService.save(memberDto);


        Optional<Member> OptionalMember= memberRepository.findById(1l);
        Member member1 = OptionalMember.get();
        // then
        Assertions.assertThat(member1.getName()).isEqualTo("모수혁");
        Assertions.assertThat(member1.getPhoneNumber()).isEqualTo("010-1234-5678");
        Assertions.assertThat(member1.getNickname()).isEqualTo("Suhyeokeee");
        Assertions.assertThat(member1.getEmail()).isEqualTo("msv31v@likelion.org");
    }

    @Test
    public void 이메일중복(){
        //given
        String name = "모수혁";
        String password = "a123456789";
        String phoneNumber = "010-1234-5678";
        String nickName = "Suhyeokeee";
        String email = "msv31v@likelion.org";
        MemberDto first = new MemberDto();
        first.setName(name);
        first.setNickname(nickName);
        first.setPassword(passwordEncoder.encode(password));
        first.setPhoneNumber(phoneNumber);
        first.setEmail(email);
        Member member = first.toEntity();

        name = "김예찬";
        password = "a123456789";
        phoneNumber = "010-1111-2222";
        nickName = "Yechan";
        email = "msv31v@likelion.org";

        MemberDto second = new MemberDto();
        second.setName(name);
        second.setEmail(email);
        second.setPassword(password);
        second.setPhoneNumber(phoneNumber);
        second.setNickname(nickName);

        // when
        memberService.save(first);
        Optional<Member> OptionalMember= memberRepository.findByEmail(email);

        if(OptionalMember.isEmpty()){
            memberService.save(second);
        }

        List<Member> all = memberRepository.findAll();
        // then
        Assertions.assertThat(all.size()).isEqualTo(1);
    }
}
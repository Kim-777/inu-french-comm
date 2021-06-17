package com.example.toyproject.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;

    @Transactional
    public Member save(MemberDto memberDto){
        memberDto.setRole(Role.GUEST);
        Member member = memberDto.toEntity();

/*        Optional<Member> emailCheck= memberRepository.findByEmail(member.getEmail());
        Optional<Member> nicknameCheck = memberRepository.findByNickname(member.getNickname());

        if(!emailCheck.isEmpty()){
            return null;
        }
        if(!nicknameCheck.isEmpty()){

        }*/
        return memberRepository.save(member);
    }
}

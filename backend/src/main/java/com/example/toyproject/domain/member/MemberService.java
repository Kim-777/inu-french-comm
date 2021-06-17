package com.example.toyproject.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;

    @Transactional
    public Member save(MemberDto memberDto){
        memberDto.setRole(Role.GUEST);
        Member member = memberDto.toEntity();
        return memberRepository.save(member);
    }
}

package com.example.CRUD_Board.service;

import com.example.CRUD_Board.domain.Member;
import com.example.CRUD_Board.repository.Member.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member)
    {
        //같은 이름 x
        validateDuplicateMember(member);
        //

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member)
    {
        memberRepository.findByName(member.getName()).ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 이름");});
    }


    //전체회원조회
    public List<Member> findMembers()
    {
        return memberRepository.findAll();
    }

    //
    public Optional<Member> findOne(Long memberId)
    {
        return memberRepository.findById(memberId);
    }
}

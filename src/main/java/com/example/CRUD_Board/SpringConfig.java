package com.example.CRUD_Board;

import com.example.CRUD_Board.repository.Member.MemberRepository;
import com.example.CRUD_Board.repository.Member.MemoryMemberRepository;
import com.example.CRUD_Board.repository.Post.MemoryPostRepository;
import com.example.CRUD_Board.repository.Post.PostRepostory;
import com.example.CRUD_Board.service.MemberService;
import com.example.CRUD_Board.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
        return new MemoryMemberRepository();
    }

    @Bean
    public PostService postService()
    {
        return new PostService(postRepostory());
    }

    @Bean
    public PostRepostory postRepostory()
    {
        return new MemoryPostRepository();
    }
}

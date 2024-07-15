package com.example.CRUD_Board;

import com.example.CRUD_Board.repository.Member.MemberRepository;
import com.example.CRUD_Board.repository.Member.MemoryMemberRepository;
import com.example.CRUD_Board.repository.Post.JpaPostRepository;
import com.example.CRUD_Board.repository.Post.MemoryPostRepository;
import com.example.CRUD_Board.repository.Post.PostRepository;
import com.example.CRUD_Board.service.MemberService;
import com.example.CRUD_Board.service.PostService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em)
    {
        this.em = em;
    }

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
    public PostRepository postRepostory()
    {
       return new JpaPostRepository(em);
    }
}

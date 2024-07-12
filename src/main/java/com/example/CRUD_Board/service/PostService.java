package com.example.CRUD_Board.service;

import com.example.CRUD_Board.domain.Post;
import com.example.CRUD_Board.repository.Post.PostRepostory;

import java.util.List;

public class PostService {
    
    private final PostRepostory postRepostory;


    public PostService(PostRepostory postRepostory)
    {
        this.postRepostory = postRepostory;
    }

    //게시글 작성(업로드)
    public Long upload(Post post)
    {
        postRepostory.save(post);
        return post.getId();
    }
    
    
    //전체 게시글 조회
    public List<Post> findPosts()
    {
        return postRepostory.findAll();
    }

    //id로 게시글 한개만 보기위해 이동하는 것
    public Post onePost(Long id)
    {
        return postRepostory.findById(id);
    }

    //제목으로 조회(검색어를 포함한)
    public List<Post> searchPosts(String keyword)
    {
        return postRepostory.findByTitle(keyword);
    }

    //비밀번호 확인
    public boolean checkPassword(Long id, String Password)
    {
        return postRepostory.findById(id).getPassword().equals(Password);
    }

    //작성자로 조회 : 나중에 만들기

    //수정
    public Long updatePost(Long id,String newTitle, String newContent)
    {
        postRepostory.update(id,newTitle, newContent);
        return id;
    }

    //삭제
    public Long deletePost(Long id)
    {
        postRepostory.delete(id);
        return id;
    }
}


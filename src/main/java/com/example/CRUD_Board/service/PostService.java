package com.example.CRUD_Board.service;

import com.example.CRUD_Board.domain.entity.Post;
import com.example.CRUD_Board.repository.Post.PostRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional //저장,변경에 필요(조회는 x)
public class PostService {
    
    private final PostRepository postRepostory;


    public PostService(PostRepository postRepostory)
    {
        this.postRepostory = postRepostory;
    }

    //게시글 작성(업로드)
    @Transactional
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
    public Optional<Post> onePost(Long id)
    {
        return postRepostory.findById(id);
    }

    //제목으로 조회(검색어를 포함한)
    public List<Post> searchPosts(String keyword)
    {
        return postRepostory.findByTitleContaining(keyword);
    }

    //비밀번호 확인
    public boolean checkPassword(Long id, String Password)
    {
        Optional<Post> post = postRepostory.findById(id);
        return post.filter(value -> Password.equals(value.getPassword())).isPresent();
//        if(post.isPresent())
//        {
//            return Password.equals(post.get().getPassword());
//        }
        //return postRepostory.findById(id).get().getPassword().equals(Password);
    }

    //작성자로 조회 : 나중에 만들기

    //수정
    @Transactional
    public Long updatePost(Long id,String newTitle, String newContent)
    {
        postRepostory.update(id,newTitle, newContent);
        return id;
    }

    //삭제
    @Transactional
    public Long deletePost(Long id)
    {
        postRepostory.deleteById(id);
        return id;
    }
}


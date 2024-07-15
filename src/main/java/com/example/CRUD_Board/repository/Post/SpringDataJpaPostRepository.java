package com.example.CRUD_Board.repository.Post;

import com.example.CRUD_Board.domain.entity.Post;
import com.example.CRUD_Board.repository.Member.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaPostRepository extends JpaRepository<Post, Long>, PostRepository {


    //findByTitle시 JPQL: select p from Post p where p.title = ?




    @Override
    Long update(Long id, String newTitle, String newContents);
}

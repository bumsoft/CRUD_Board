package com.example.CRUD_Board.repository.Post;

import com.example.CRUD_Board.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepostory {

    Post save(Post post);
    Optional<Post> findByWriter(String Writer);
    List<Post> findAll();
    Post findById(Long id);
    List<Post> findByTitle(String keyword);

    Long delete(Long id);

    Long update(Long id,String newContents);
}

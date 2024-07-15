package com.example.CRUD_Board.repository.Post;

import com.example.CRUD_Board.domain.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    Post save(Post post);
    List<Post> findAll();
    Optional<Post> findById(Long id);
    List<Post> findByTitleContaining(String keyword);

    void deleteById(Long id);

    Long update(Long id,String newTitle, String newContents);
}

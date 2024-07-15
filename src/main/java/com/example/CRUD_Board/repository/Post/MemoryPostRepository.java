package com.example.CRUD_Board.repository.Post;

import com.example.CRUD_Board.domain.entity.Post;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryPostRepository implements PostRepository {

    private static Map<Long, Post> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Post save(Post post)
    {
        sequence++;
        post.setId(sequence);
        store.put(sequence,post);
        return post;
    }

    @Override
    public List<Post> findAll()
    {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Post> findById(Long id)
    {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Post> findByTitleContaining(String keyword)
    {
        return new ArrayList<>(store.values().stream().filter(post -> post.getTitle().contains(keyword)).collect(Collectors.toList()));
    }

    @Override
    public void deleteById(Long id)
    {
        store.remove(id);
    }

    @Override
    public Long update(Long id, String newTitle, String newContents)
    {
        store.get(id).setTitle(newTitle);
        store.get(id).setContent(newContents);
        return id;
    }
}

package com.example.CRUD_Board.repository.Post;

import com.example.CRUD_Board.domain.entity.Post;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaPostRepository implements PostRepository {

    private final EntityManager em;

    public JpaPostRepository(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public Post save(Post post)
    {
        em.persist(post);
        return post;
    }

    @Override
    public List<Post> findAll()
    {
        return em.createQuery("select p from Post p", Post.class).getResultList();
    }

    public List<Post> findByWriter(String W)
    {
        return em.createQuery("select p from Post p where p.Writer = :Writer", Post.class)
                .setParameter("Writer", W) // :Writer가 w로 치환
                .getResultList();
    }

    @Override
    public Optional<Post> findById(Long id)
    {
       Post post = em.find(Post.class, id);
       return Optional.ofNullable(post);

    }

    @Override
    public List<Post> findByTitleContaining(String keyword)
    {
        return em.createQuery("select p from Post p where p.Title like :keyword", Post.class)
                .setParameter("keyword", "%" + keyword + "%").getResultList();
    }

    @Override
    public void deleteById(Long id)
    {
        Post post = em.find(Post.class, id);
        em.remove(post);
    }


    @Override
    public Long update(Long id, String newTitle, String newContents)
    {
        Post post = em.find(Post.class, id);
        post.setTitle(newTitle);
        post.setContent(newContents);
        em.merge(post);
        return id;
    }
}

package com.example.CRUD_Board.controller;

import com.example.CRUD_Board.domain.entity.Post;
import com.example.CRUD_Board.dto.PasswordForm;
import com.example.CRUD_Board.dto.PostForm;
import com.example.CRUD_Board.dto.SearchForm;
import com.example.CRUD_Board.dto.UpdateForm;
import com.example.CRUD_Board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService)
    {
        this.postService = postService;
    }
    @GetMapping("/posts/new")
    public String createForm()
    {
        return "posts/createPostForm";
    }

    @PostMapping("/posts/new")
    public String create(PostForm form)
    {
        Post post = new Post();
        post.setWriter(form.getWriter());
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setPassword(form.getPassword());

        postService.upload(post);

        return "redirect:/";
    }

    @GetMapping("/posts")
    public String list(Model model)
    {
        List<Post> posts = postService.findPosts();
        model.addAttribute("posts", posts);
        return "posts/postList";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable("id") Long id, Model model)
    {
        Post post = postService.onePost(id).get();
        model.addAttribute("post", post);
        return "posts/post";
    }

    @PostMapping("/posts/search")
    public String searchByTitle(SearchForm form, Model model)
    {
        List<Post> posts = postService.searchPosts(form.getKeyword());
        model.addAttribute("posts", posts);

        return "posts/postList";
    }

    @PostMapping("/post/delete/{id}")
    public String deletePost(@PathVariable("id")Long id, PasswordForm form, Model model)
    {
        if(postService.checkPassword(id, form.getPassword()))
        {
            postService.deletePost(id);
        }
        return "redirect:/posts";
    }


    @GetMapping("/post/update/{id}")
    public String updatePost(@PathVariable("id")Long id, Model model)
    {
        Post post = postService.onePost(id).get();
        model.addAttribute("post",post);
        return "posts/updatePostForm";
    }
    @PostMapping("/post/update/{id}")
    public String updatePost2(@PathVariable("id")Long id, UpdateForm form)
    {
        if (postService.checkPassword(id, form.getPassword()))
        {
            postService.updatePost(id, form.getTitle(), form.getContent());
        }
        return "redirect:/posts";
    }
}

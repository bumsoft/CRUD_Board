package com.example.CRUD_Board.controller;

import com.example.CRUD_Board.domain.Post;
import com.example.CRUD_Board.dto.PasswordForm;
import com.example.CRUD_Board.dto.PostForm;
import com.example.CRUD_Board.dto.SearchForm;
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

    private boolean t = false;

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
        if(!t)
        {
            t=true;
            Post p1 = new Post();
            p1.setTitle("제목1");
            p1.setWriter("진범1");
            p1.setContent("내용1");
            p1.setPassword("1");
            Post p2 = new Post();
            p2.setTitle("제목2");
            p2.setWriter("진범2");
            p2.setContent("내용2");
            p2.setPassword("2");
            Post p3 = new Post();
            p3.setTitle("제목3");
            p3.setWriter("진범3");
            p3.setContent("내용3");
            p3.setPassword("3");
            postService.upload(p1);
            postService.upload(p2);
            postService.upload(p3);
        }


        List<Post> posts = postService.findPosts();
        model.addAttribute("posts", posts);
        return "posts/postList";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable("id") Long id, Model model)
    {
        Post post = postService.onePost(id);
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
       // List<Post> posts = postService.findPosts();
       // model.addAttribute("posts",posts);
        return "redirect:/posts";
    }

}

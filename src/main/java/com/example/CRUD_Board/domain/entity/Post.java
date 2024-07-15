package com.example.CRUD_Board.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {

    @Id
    //dbms가 자동으로 id생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Writer;
    private String Password;
    private String Title;
    private String Content;


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getWriter()
    {
        return Writer;
    }

    public void setWriter(String writer)
    {
        Writer = writer;
    }

    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String title)
    {
        Title = title;
    }

    public String getContent()
    {
        return Content;
    }

    public void setContent(String content)
    {
        Content = content;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String password)
    {
        Password = password;
    }
}

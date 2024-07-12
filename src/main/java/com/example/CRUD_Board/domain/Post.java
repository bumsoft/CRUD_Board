package com.example.CRUD_Board.domain;

public class Post {

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

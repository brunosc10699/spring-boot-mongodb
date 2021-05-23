package com.bruno.workshopspringmongo.dto;

import com.bruno.workshopspringmongo.domain.Comment;
import com.bruno.workshopspringmongo.domain.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDTO {

    private String id;
    private Date date;
    private String title;
    private String body;

    private AuthorDTO author;

    private List<CommentDTO> comments = new ArrayList<>();

    public PostDTO(){}

    public PostDTO(Post post){
        id = post.getId();
        date = post.getDate();
        title = post.getTitle();
        body = post.getBody();
        author = post.getAuthor();
        comments = post.getComments();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }
}

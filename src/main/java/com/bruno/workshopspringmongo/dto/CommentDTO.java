package com.bruno.workshopspringmongo.dto;

import com.bruno.workshopspringmongo.domain.Comment;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

    private String text;
    private Date date;
    private AuthorDTO author;

    public CommentDTO(){}

    public CommentDTO(String text, Date date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public CommentDTO(Comment comment) {
        text = comment.getText();
        date = comment.getDate();
        author = comment.getAuthor();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}

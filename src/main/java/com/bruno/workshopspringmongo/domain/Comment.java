package com.bruno.workshopspringmongo.domain;

import com.bruno.workshopspringmongo.dto.AuthorDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
public class Comment implements Serializable {

    private String text;
    private Date date;
    private AuthorDTO author;

    public Comment(){}

    public Comment(String text, Date date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
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

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", date=" + date +
                ", author=" + author +
                '}';
    }
}

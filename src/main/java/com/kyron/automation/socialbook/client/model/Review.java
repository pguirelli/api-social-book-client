package com.kyron.automation.socialbook.client.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Review {

    private Long id;

    private String text;

    private String userName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;

    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}

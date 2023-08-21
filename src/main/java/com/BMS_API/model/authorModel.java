package com.BMS_API.model;

import com.BMS_API.entities.book;

import java.util.Date;
import java.util.Set;

public class authorModel {
    private String name;
    private Date dateOfBirth;
    private String biography;

    private Set<book> authorBooks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Set<book> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(Set<book> authorBooks) {
        this.authorBooks = authorBooks;
    }

}

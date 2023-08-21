package com.BMS_API.entities;

import com.BMS_API.Deserializer.AuthorDeserializer;
import com.BMS_API.Deserializer.BookDeserializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@JsonDeserialize(using = BookDeserializer.class)
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer publisherId;

    @Column
    private String title;
    @Column
    private String isbn;
    @Column
    private String description;


    @ManyToMany(cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "authorBooks")
    @JsonIgnore
    private Set<author> authors = new HashSet<>();

    book(){}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<author> authors) {
        this.authors = authors;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public book(String title, String isbn, String description, Set<author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.authors = authors;
    }
    public book(String title, String isbn, String description, Set<author> authors,int publisherId) {
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.authors = authors;
        this.publisherId=publisherId;
    }
}

package com.BMS_API.entities;

import com.BMS_API.Deserializer.AuthorDeserializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "author")
@JsonDeserialize(using = AuthorDeserializer.class)
public class author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    private String name;
    @Column
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateOfBirth;
    @Column
    private String biography;


    @ManyToMany(cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "author_books",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") })
    @JsonManagedReference
    private Set<book> authorBooks;

    public author(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public void addBook(book book) {
        this.authorBooks.add(book);
        book.getAuthors().add(this);
    }

    public void removeBook(long bookId) {
        book book = this.authorBooks.stream().filter(t -> t.getId() == bookId).findFirst().orElse(null);
        if (book != null) {
            this.authorBooks.remove(book);
            book.getAuthors().remove(this);
        }
    }

    public author(String name, Date DOB, String biography,Set<book> authorBooks) {
        this.name = name;
        this.dateOfBirth = DOB;
        this.biography = biography;
        this.authorBooks = authorBooks;
    }

}

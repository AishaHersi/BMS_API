package com.BMS_API.controller;

import com.BMS_API.entities.author;
import com.BMS_API.entities.book;
import com.BMS_API.services.BookService;
import com.BMS_API.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PublisherController {

    @Autowired
    AuthorService PS;

    @Autowired
    BookService BS;

    @RequestMapping(value = "/getAuthors", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAuthors()
    {
        return ResponseEntity.ok(Map.ofEntries(
                Map.entry("message", "Authors found"),
                Map.entry("data", PS.getAuthors())
        ));
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addAuthor(@RequestBody author author) {
        if (!PS.AuthorExisted(author))
        {
        return ResponseEntity.ok(Map.ofEntries(
                Map.entry("message", "Author added successfully"),
                Map.entry("data", PS.addAuthor(author))
        ));
        }
        else {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Error, Author with the same name already existed")
            ));
        }
        }

    @RequestMapping(value = "/updateAuthor/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateAuthor(@RequestBody author author,@PathVariable int id) {
        if (PS.getAuthorById(id)!=null)
        {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Author details updated successfully"),
                    Map.entry("data", PS.updateAuthor(author,id))
            ));
        }
        else {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Error, Author not existed")
            ));
        }
    }

    @RequestMapping(value = "/removeAuthor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> removeAuthor(@PathVariable int id ) {
        if(PS.removeAuthor(id))
        {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Author removed successfully")
            ));
        }
        else {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Error, Author not existed")
            ));
        }
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addBook(@RequestBody book book) {
        if(!book.getAuthors().isEmpty()) {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Book added successfully"),
                    Map.entry("data", BS.addBook(book))
            ));
        }
        else
        {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Error, Book should have at least one author")
            ));
        }
    }

    @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> allBooks() {
        return ResponseEntity.ok(Map.ofEntries(
                Map.entry("message", "Books found"),
                Map.entry("data", BS.getBooks())
        ));
    }

    @RequestMapping(value = "/removeBook/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> removeBook(@PathVariable int id ) {
        if(BS.removeBook(id))
        {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Book removed successfully")
            ));
        }
        else {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Error, Book not existed")
            ));
        }
    }
}


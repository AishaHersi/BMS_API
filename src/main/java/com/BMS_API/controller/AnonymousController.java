package com.BMS_API.controller;

import com.BMS_API.entities.book;
import com.BMS_API.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("anonymous")
public class AnonymousController {

    @Autowired
    BookService BS;

    @RequestMapping(value = "/findBook", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> findBook(@RequestBody String isbn) {
        book b=BS.findBook(isbn);
        if(b!=null)
        {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Book found"),
                    Map.entry("data", b)
            ));
        }
        else {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Book not found")
                    ));
        }
    }
}

package com.BMS_API.controller;

import com.BMS_API.entities.author;
import com.BMS_API.entities.login;
import com.BMS_API.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminConteoller {

    @Autowired
    AdminService AS;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> login(@RequestBody login login) {
        if(AS.login(login))
        {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Logged in successfully")
            ));
        }
        else
        {
            return ResponseEntity.ok(Map.ofEntries(
                    Map.entry("message", "Error, Check info then try again")
            ));
        }
    }

    @RequestMapping(value = "/number_of_publishers", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> number_of_publishers() {
        return ResponseEntity.ok(Map.ofEntries(
                Map.entry("message", "Total number of publishers is: "+AS.number_of_publishers())
        ));
    }

    @RequestMapping(value = "/number_of_books_per_publisher", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>>number_of_books_per_publisher() {
        return AS.number_of_books_per_publisher();
    }

    @RequestMapping(value = "/admin/average_num_of_books", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>>average_num_of_books() {
        return AS.average_num_of_books();
    }
}

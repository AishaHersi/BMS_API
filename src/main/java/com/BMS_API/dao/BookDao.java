package com.BMS_API.dao;

import com.BMS_API.entities.author;
import com.BMS_API.entities.book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDao extends CrudRepository<book, Integer> {
    book findById(int id);

    book findByIsbn(String isbn);
    long countByPublisherId(int id);
}

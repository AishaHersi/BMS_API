package com.BMS_API.dao;

import com.BMS_API.entities.author;
import com.BMS_API.entities.book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDao extends CrudRepository<author, Integer> {
    author findByName(String name);
    author findById(int id);
    author deleteById(int id);
    author deleteByName(String name);
}

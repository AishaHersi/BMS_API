package com.BMS_API.services;

import com.BMS_API.dao.AuthorDao;
import com.BMS_API.dao.BookDao;
import com.BMS_API.dao.UserDao;
import com.BMS_API.entities.DAOUser;
import com.BMS_API.entities.author;
import com.BMS_API.entities.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao dao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorDao authorDao;

    public book addBook(book book)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        DAOUser user=userDao.findByUsername(auth.getName());
        book.setPublisherId(user.getId());
        List<author> authors = new ArrayList<>(book.getAuthors());
            for (int i = 0; i < authors.size(); i++) {
                author a = authors.get(i);
                if (authorDao.findByName(a.getName()) != null) {
                    a.addBook(book);
                } else {
                    a.addBook(book);
                    authorDao.save(a);
                }
            }
        return dao.save(book);
    }

    public Iterable<book> getBooks()
    {
        return dao.findAll();
    }

    public boolean removeBook(int id)
    {
        if(dao.existsById(id))
        {
            book b=dao.findById(id);
            List<author> authors = new ArrayList<>(b.getAuthors());
            for (int i = 0; i < authors.size(); i++) {
                authors.get(i).removeBook(id);
            }
            dao.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }

    public book findBook(String isbn)
    {
        return dao.findByIsbn(isbn);
    }
}

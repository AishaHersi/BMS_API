package com.BMS_API.services;

import com.BMS_API.dao.AuthorDao;
import com.BMS_API.entities.author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorService {

    @Autowired
    private AuthorDao dao;
    public author addAuthor(author author)
    {
        return dao.save(author);
    }

    public author getAuthor(author author)
    {

        return dao.findByName(author.getName());
    }
    public Iterable<author> getAuthors()
    {
        return dao.findAll();
    }

    public author getAuthorById(int id)
    {
        return dao.findById(id);
    }
    public boolean AuthorExisted(author author)
    {
        return dao.findByName(author.getName()) != null;
    }

    @Transactional
    public boolean removeAuthor(int id)
    {
        author a= dao.findById(id);
        if(a!=null) {
            dao.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }
     public author updateAuthor(author author,int id)
     {
         author a= dao.findById(id);
         if(!author.getName().isEmpty())
         {
             a.setName(author.getName());
         }
         if(author.getDateOfBirth()!=null)
         {
             a.setDateOfBirth(author.getDateOfBirth());
         }
         if (!author.getBiography().isEmpty())
         {
             a.setBiography(author.getBiography());
         }
             return dao.save(a);
     }
}

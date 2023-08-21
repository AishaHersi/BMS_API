package com.BMS_API.services;

import com.BMS_API.dao.BookDao;
import com.BMS_API.dao.UserDao;
import com.BMS_API.entities.DAOUser;
import com.BMS_API.entities.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    public boolean login(login login)
    {
        DAOUser u=userDao.findByUsername(login.getUsername());
        if(u!=null)
        return u.getPassword().equals(login.getPassword()) && u.getRole() == 1;
        else
            return false;
    }
    public long number_of_publishers()
    {
        return userDao.countByRole(2);
    }

    public ResponseEntity<Map<String, Object>> number_of_books_per_publisher()
    {
        List<DAOUser> publishers=userDao.findAllByRole(2);
        Map<String, Object> map=new HashMap<>();
        for (DAOUser u:publishers) {
            map.put(u.getName(),bookDao.countByPublisherId(u.getId()));
        }
        return ResponseEntity.ok(Map.ofEntries(
                Map.entry("message", "publishers names and number of books published by them"),
                Map.entry("data", map)
        ));
    }

    public ResponseEntity<Map<String, Object>> average_num_of_books()
    {
        List<DAOUser> publishers=userDao.findAllByRole(2);
        return ResponseEntity.ok(Map.ofEntries(
                Map.entry("message", "publishers names and number of books published by them"),
                Map.entry("data", " ")
        ));
    }
}

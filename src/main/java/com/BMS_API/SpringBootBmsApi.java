package com.BMS_API;

import com.BMS_API.dao.UserDao;
import com.BMS_API.entities.DAOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBmsApi implements CommandLineRunner {

	@Autowired
	UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBmsApi.class, args);
	}

	@Override
	public void run(String... args)throws Exception {
		if (!userDao.existsById(1)) {
			userDao.save(new DAOUser("admin", "adminpass", "scott", "", "", 1));
		}
	}
}
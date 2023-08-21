package com.BMS_API.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BMS_API.entities.DAOUser;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	DAOUser findByUsername(String username);
	long countByRole(int role);

	List<DAOUser> findAllByRole(int role);
}
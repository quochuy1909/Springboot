package com.ntqh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntqh.dao.UsersDAO;
import com.ntqh.model.Users;

@Service
public class UsersService {
	
	@Autowired
	UsersDAO userDAO;
	
	public List<Users> findAllUsers(){
		return userDAO.findAll();
	}
}

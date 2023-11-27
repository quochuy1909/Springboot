package com.ntqh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ntqh.model.Users;
import com.ntqh.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	UsersService userService;
	
	@GetMapping("/user/all")
	public ResponseEntity<List<Users>> getListUser(){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
		responseHeaders.set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		return new ResponseEntity<List<Users>>(userService.findAllUsers(),responseHeaders,HttpStatus.OK);
	}
	@GetMapping("/user/test")
	public List<Users> test () {
		return userService.findAllUsers();
	}
}

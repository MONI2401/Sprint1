package com.cg.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.entities.User;
import com.cg.cars.service.IUserService;

/**
*Author: Sarath Sathyan
*Date:08-04-2021
*Description:This is User Controller Layer
**/

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private IUserService service;
	
	@PostMapping(path="/signin", consumes="application/json")
	public ResponseEntity<Boolean> signin(@RequestBody User user){
		return new ResponseEntity<Boolean>(service.signin(user),HttpStatus.OK);
	}
	
	@PutMapping(path="/changePassword",consumes="application/json")
	public ResponseEntity<Boolean> changePassword(@RequestBody User user){
		return new ResponseEntity<Boolean>(service.changePassword(user, user.getId()),HttpStatus.OK);
	}

}

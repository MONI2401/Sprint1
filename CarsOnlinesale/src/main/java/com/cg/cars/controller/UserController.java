package com.cg.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.cars.entities.User;
import com.cg.cars.service.IUserServices;

public class UserController {
	@Autowired
	private IUserServices service;
	
	@PostMapping("/signin")
	public String  signin(@RequestBody User user) {
		service.signIn(user);
		return null;
	}
	
	@GetMapping("/signout")
	public String  signout() {
		
		return service.signOut();
	}
	

	
	

}

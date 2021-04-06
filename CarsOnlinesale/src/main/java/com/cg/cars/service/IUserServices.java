package com.cg.cars.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.cg.cars.entities.User;

public interface IUserServices extends UserDetails{
	public Void signIn(User user);

	public String signOut();

	
	

}

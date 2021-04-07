package com.cg.cars.service;

import com.cg.cars.entities.User;

public interface IUserService {
	public boolean signin(User user);
	public boolean changePassword(User user,int id);

}

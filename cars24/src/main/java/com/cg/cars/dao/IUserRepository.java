package com.cg.cars.dao;

import com.cg.cars.entities.User;

public interface IUserRepository {
	public User signIn(User user);
	public User signOut(User user);
	public User changePassword(long id, User user);

}

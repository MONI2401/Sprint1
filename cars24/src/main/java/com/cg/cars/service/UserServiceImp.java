package com.cg.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.dao.IUserRepository;
import com.cg.cars.entities.User;

@Service
public class UserServiceImp implements IUserService {
	
	@Autowired
	private IUserRepository userRepo;

	@Override
	public boolean signin(User user) {
		User u=userRepo.findById(user.getId()).get();
		if(u.getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean changePassword(User user, int id) {
		User u=new User();
		u=userRepo.save(user);
		return true;
	}

}

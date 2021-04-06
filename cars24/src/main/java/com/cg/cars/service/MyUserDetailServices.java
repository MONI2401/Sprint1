package com.cg.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.cars.dao.IUserRepository;
import com.cg.cars.entities.User;

@Service
public class MyUserDetailServices implements UserDetailsService {
	
	@Autowired
	private  IUserRepository repo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


				User user =	repo.findByUsername(username);
				
				if(user == null)
					throw new UsernameNotFoundException("User Not Found 404!");
				
				
		
		
		return new UserPrinciple(user);
	}

}

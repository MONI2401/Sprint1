package com.cg.cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cars.entities.User;
import com.cg.cars.service.IUserService;
@SpringBootTest
class UserServiceImpTest {
	@Autowired
	IUserService service;

	@Disabled
	@Test
	void testSignin() {
		User user= new User();
		user.setId(1);
		user.setPassword("admin");
		boolean signinUser= service.signin(user);
		assertEquals(true, signinUser);
		
	}

	@Test
	void testChangePassword() {
		User user=new User();
		user.setId(1);
		user.setPassword("admin");
		boolean changepassword=service.changePassword(user, 1);
		assertEquals(true, changepassword);
	}

}

package com.cg.cars;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.cars.entities.User;
import com.cg.cars.exception.UserNotFoundException;
import com.cg.cars.exception.UserServiceException;
import com.cg.cars.model.UserDTO;
import com.cg.cars.service.UserServiceImpl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UserServiceImplTests {

	@Autowired
	UserServiceImpl service;

	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	private static long userId;

	@Test
	@Order(1)
	void testAddUser() {
		
		LOGGER.info("TEST CASE TC_80");
		User user=new User(1, "password", "admin", "username");
		try
		{
			UserDTO dto = service.addUser(user);
		user.setUserId(dto.getUserId());
		boolean equals=false;
		equals = dto.getPassword().equals(user.getPassword()) && dto.getRole().equals(user.getRole()) && dto.getusername().equals(dto.getusername());
		userId=dto.getUserId();
		assertTrue(equals);
		if(equals)
			LOGGER.info("User added successfully");
		else
			LOGGER.error("User is not added");
		}
		catch(UserServiceException e)
		{
			LOGGER.error("User is not added due to " + e.getMessage());
			fail("User is not added");
		}
	}

	@Test
	@Order(2)
	void testAddUserAgain() {
		
		LOGGER.info("TEST CASE TC_81");
		User user=new User(1, "password", "admin", "username");
		assertThrows(DataIntegrityViolationException.class,()->service.addUser(user));
		LOGGER.info("Multiple users with same user name not allowed");
	}

	@Test
	@Order(3)
	void testGetId() {

		LOGGER.info("TEST CASE TC_82");
		UserDTO getUser = service.getId(userId);
		assertNotNull(getUser);
		LOGGER.info("User with valid ID got retrived");
	}

	@Order(4)
	@Test
	void getWrongID()
	{
		LOGGER.info("TEST CASE TC_83");
		assertThrows(UserServiceException.class, ()->service.getId(1234));
		LOGGER.info("User with invalid ID throwed exception");
	}
	@Order(5)
	@Test
	void testUpdateUser() {
		LOGGER.info("TEST CASE TC_84");
		User user=new User(userId, "pwdnew", "admin", "username");
		UserDTO dto = service.updateUser(user);
		assertNotNull(dto);
		LOGGER.info("User with valid ID got updated");
	}

	@Order(6)
	@Test
	void testUpdateUserInvalidID() {
		LOGGER.info("TEST CASE TC_85");
		User user=new User(150, "pwdnew", "admin", "username");
		assertThrows(UserServiceException.class, ()-> service.updateUser(user));
		LOGGER.info("User with invalid ID thrown UserServiceException");
	}

	@Test
	@Order(7)
	void testValidateUsername() {
		LOGGER.info("TEST CASE TC_86");
		User user=new User(150, "pwdnew", "admin", "myusername");
		assertDoesNotThrow(()->UserServiceImpl.validateUsername(user));
		LOGGER.info("User with valid name passed");
	}

	@Test
	@Order(8)
	void testValidateUsernameInvalidData() {
		LOGGER.info("TEST CASE TC_87");
		User user=new User(150, "pwdnew", "admin", "my");
		assertThrows(UserServiceException.class,()->UserServiceImpl.validateUsername(user));
		LOGGER.info("User with invalid name caused exception");

	}

	@Order(9)
	@Test
	void testValidatePassword() {
		LOGGER.info("TEST CASE TC_88");
		User user=new User(150, "pwdnew", "admin", "myusername");
		assertDoesNotThrow(()->UserServiceImpl.validatePassword(user));
		LOGGER.info("User with valid name password");

	}

	@Order(10)
	@Test
	void testValidatePasswordInvalidData() {
		LOGGER.info("TEST CASE TC_89");
		User user=new User(150, "pw", "admin", "myusername");
		assertThrows(UserServiceException.class,()->UserServiceImpl.validatePassword(user));
		LOGGER.info("User with valid name password");
	}

	
	@Order(11)
	@Test
	void testCheckUser() {
		LOGGER.info("TEST CASE TC_90");
		try
		{
			assertTrue(service.checkUser(userId, "username", "pwdnew"));
			LOGGER.info("User is valid");
		}
		catch(UserNotFoundException e)
		{
			fail("User is not found or password is incorrect");
			LOGGER.error("User is invalid");
		}
	}

	@Order(12)
	@Test
	void testCheckUserInvalidData()
	{
		LOGGER.info("TEST CASE TC_91");
		assertThrows(UserNotFoundException.class, ()->service.checkUser(1205, "username", "pwdnew"));
		LOGGER.info("User is valid");
	}


	@Order(13)
	@Test
	void testValidateUserId() {
		LOGGER.info("TEST CASE TC_92");
		User user=new User(userId+100, "pwdnew", "admin", "umysername");
		assertTrue(service.validateUserId(user));
		LOGGER.info("User with valid ID passed");
	}

	@Order(14)
	@Test
	void testValidateUserIdInvalidID() {
		LOGGER.info("TEST CASE TC_93");
		User user=new User(userId, "pwdnew", "admin", "umysername");
		assertFalse(service.validateUserId(user));
		LOGGER.info("User with invalid ID got caught");
	}


	@Order(15)
	@Test
	void testDeleteUser() {
		LOGGER.info("TEST CASE TC_94");
		try {
			assertNotNull(service.deleteUser(userId));
			LOGGER.info("User is deleted with valid ID");
		} catch (UserNotFoundException e) {
			fail("User cannot be deleted due to " + e.getMessage());
		}
	}

	@Order(16)
	@Test
	void testDeleteUserInvalidID() {
		LOGGER.info("TEST CASE TC_95");
		assertThrows(UserServiceException.class, ()->service.deleteUser(1000));
		LOGGER.info("User with invalid ID thrown exception");
	}


}

package com.cg.cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.cars.entities.Customer;
import com.cg.cars.service.CustomerServiceImp;

class CustomerServiceImpTest {
@Autowired	
CustomerServiceImp service;

static Customer  customer = new Customer();	
@BeforeAll
public  static void beforeAll() {
	customer.setName("Monisha");
}

	@Test
	void testAddCustomer() {
		customer.setName("Monisha");
		//customer.setDob("2000-01-24");
		
		assertEquals("Monisha", customer.getName());
		
	}

	@Test
	void testRemoveCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllCustomers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomersByCity() {
		fail("Not yet implemented");
	}

	@Test
	void testIsValidCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testValidateUserName() {
		fail("Not yet implemented");
	}

	@Test
	void testValidateUserMail() {
		fail("Not yet implemented");
	}

	@Test
	void testValidateUserContact() {
		fail("Not yet implemented");
	}

}

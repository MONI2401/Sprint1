package com.cg.cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.cars.entities.Customer;
import com.cg.cars.model.CustomerDTO;
import com.cg.cars.service.CustomerServiceImp;

class CustomerServiceImpTest {

	static Customer customer = new Customer();

	@Autowired
	CustomerServiceImp service;

	@Test
	void testAddCustomer() {
		
		customer.setName("Monisha");
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
		CustomerDTO getCusId = service.getCustomer(5);
		assertEquals("Monisha", getCusId.getName());

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

package com.cg.cars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cars.entities.Address;
import com.cg.cars.entities.Customer;
import com.cg.cars.model.CustomerDTO;
import com.cg.cars.service.ICustomerService;
import com.cg.cars.utils.CustomerUtils;

@SpringBootTest
class CustomerServiceImpTest {

	static Customer customer = new Customer();
	@Autowired
	private ICustomerService service;


	@Disabled
	@Test
	void testAddCustomer() {
		
		Customer c=new Customer();
		c.setUserId(13);
		c.setName("Avinash");
		c.setEmail("avinash@gmail.com");
		c.setContactNo("9840712511");
		c.setDob(LocalDate.parse("2000-12-01"));
		c.setAddress(new Address("A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012 ));
		Customer customerAdd= CustomerUtils.convertToCustomer(service.addCustomer(c));
		c.setUserId(customerAdd.getUserId());
		assertEquals(c,customerAdd);
	}

	@Disabled
	@Test
	void testRemoveCustomer() {
		Customer c=new Customer();
		c.setUserId(68);
		c.setName("Avinash");
		c.setEmail("avinash@gmail.com");
		c.setContactNo("9840712511");
		c.setDob(LocalDate.parse("2000-12-01"));
		c.setAddress(new Address("A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012 ));
		Customer customerRem= CustomerUtils.convertToCustomer(service.removeCustomer(68));
		c.setUserId(customerRem.getUserId());
		assertEquals(c, customerRem);
	}

	@Disabled
	@Test
	void testUpdateCustomer() {
		Customer c=new Customer();
		c.setUserId(19);
		c.setName("Avinash Ram");
		c.setEmail("avinash@gmail.com");
		c.setContactNo("9840712511");
		c.setDob(LocalDate.parse("2000-12-01"));
		c.setAddress(new Address("A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012 ));
		Customer cUpdate=CustomerUtils.convertToCustomer(service.updateCustomer(19, c));
		assertEquals(c, cUpdate);
	}

	@Test
	void testGetCustomer() {
		CustomerDTO getCusId = service.getCustomer(1);
		assertEquals("moni", getCusId.getName());

	}

	@Test
	void testGetAllCustomers() {
		List<Customer> list= new ArrayList<Customer>();
		Customer c=new Customer();
		c.setUserId(19);
		c.setName("Avinash Ram");
		c.setEmail("avinash@gmail.com");
		c.setContactNo("9840712511");
		c.setDob(LocalDate.parse("2000-12-01"));
		c.setAddress(new Address("A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012 ));
		Customer c1=new Customer();
		c1.setUserId(1);
		c1.setName("moni");
		c1.setEmail("abcd@gmail.com");
		c1.setContactNo("9840732849");
		c1.setDob(LocalDate.parse("2000-01-24"));
		c1.setAddress(new Address("3", "Nehru St", "Anna Nagar", "Chennai","Tamil Nadu",600068 ));
		list.add(c1);
		list.add(c);
		List<CustomerDTO> DTOlist=CustomerUtils.convertToCustomerDtoList(list);
		List<CustomerDTO> result= service.getAllCustomers();
		DTOlist.sort(null);
		result.sort(null);
		assertEquals(DTOlist, result);
	}

	@Test
	void testGetCustomersByCity() {
		List<Customer> list= new ArrayList<Customer>();
		Customer c=new Customer();
		c.setUserId(19);
		c.setName("Avinash Ram");
		c.setEmail("avinash@gmail.com");
		c.setContactNo("9840712511");
		c.setDob(LocalDate.parse("2000-12-01"));
		c.setAddress(new Address("A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012 ));
		list.add(c);
		List<CustomerDTO> DTOlist=CustomerUtils.convertToCustomerDtoList(list);
		List<CustomerDTO> result=service.getCustomersByCity("Chennai");
		assertEquals(DTOlist,result );
		
		
		
	}

	
}

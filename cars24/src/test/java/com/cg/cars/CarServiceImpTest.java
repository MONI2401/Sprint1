package com.cg.cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cars.entities.Address;
import com.cg.cars.entities.Car;
import com.cg.cars.entities.Customer;
import com.cg.cars.service.ICarService;
import com.cg.cars.utils.CarUtils;
@SpringBootTest
class CarServiceImpTest {

	static Car car=new  Car();
	
	@Autowired
	ICarService service;
	
	@Test
	void testAddCar() {
		Car c= new Car();
		c.setCarId(20);
		c.setBrand("Audi");
		c.setModel("R8");
		c.setVariant("High milege");
		c.setRegistrationYear(LocalDate.parse("2021-01-12"));
		c.setRegistrationState("Kerala");
		c.setCustomers(new Customer(19,"Avinash Ram","avinash@gmail.com","9840712511",LocalDate.parse("2000-12-01"),"A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012));
		Car addcar=CarUtils.convertToCar(service.addCar(c));
		assertEquals(c, addcar);
	}

	@Test
	void testRemoveCar() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateCar() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCar() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllCars() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCarsByModel() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCarsByBrand() {
		fail("Not yet implemented");
	}

}

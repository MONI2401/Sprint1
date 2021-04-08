package com.cg.cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cars.entities.Car;
import com.cg.cars.entities.Customer;
import com.cg.cars.model.CarDTO;
import com.cg.cars.service.ICarService;
import com.cg.cars.utils.CarUtils;
@SpringBootTest
class CarServiceImpTest {

	static Car car=new  Car();
	
	@Autowired
	ICarService service;
	
	
	@Disabled
	@Test
	void testAddCar() {
		Car c= new Car();
		c.setCarId(20);
		c.setBrand("Audi");
		c.setModel("R8");
		c.setVariant("High milege");
		c.setRegistrationYear(LocalDate.parse("2021-01-12"));
		c.setRegistrationState("Kerala");
		c.setCustomers(new Customer(1,"Avinash","avinash@gmail.com","9840712511",LocalDate.parse("2000-12-01"),"A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012));
		Car addcar=CarUtils.convertToCar(service.addCar(c));
		c.setCarId(addcar.getCarId());
		assertEquals(c, addcar);
	}

	@Disabled
	@Test
	void testRemoveCar() {
		Car c= new Car();
		c.setCarId(20);
		c.setBrand("Audi");
		c.setModel("R8");
		c.setVariant("High milege");
		c.setRegistrationYear(LocalDate.parse("2021-01-12"));
		c.setRegistrationState("Kerala");
		c.setCustomers(new Customer(19,"Avinash Ram","avinash@gmail.com","9840712511",LocalDate.parse("2000-12-01"),"A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012));
		Car carrem=CarUtils.convertToCar(service.removeCar(20));	
		assertEquals(c, carrem);
	}

	@Disabled
	@Test
	void testUpdateCar() {
		Car c= new Car();
		c.setCarId(36);
		c.setBrand("Audi");
		c.setModel("R8");
		c.setVariant("High milege");
		c.setRegistrationYear(LocalDate.parse("2021-01-12"));
		c.setRegistrationState("Kerala");
		c.setCustomers(new Customer(19,"Avinash Ram","avinash@gmail.com","9840712511",LocalDate.parse("2000-12-01"),"A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012));
		Car carupd=CarUtils.convertToCar(service.updateCar(36, c));
		assertEquals(c, carupd);
	}

	@Test
	void testGetCar() {
		CarDTO getcarId=service.getCar(36);
		assertEquals("Audi", getcarId.getBrand());
	}

	@Test
	void testGetAllCars() {
		List<Car>list = new ArrayList<Car>();
		Car c= new Car();
		c.setCarId(36);
		c.setBrand("Audi");
		c.setModel("R8");
		c.setVariant("High milege");
		c.setRegistrationYear(LocalDate.parse("2021-01-12"));
		c.setRegistrationState("Kerala");
		c.setCustomers(new Customer(19,"Avinash Ram","avinash@gmail.com","9840712511",LocalDate.parse("2000-12-01"),"A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012));
		list.add(c);
		List<CarDTO> dtolist=CarUtils.convertToCarDtoList(list);
		List<CarDTO> result=service.getAllCars();
		dtolist.sort(null);
		result.sort(null);
		assertEquals(dtolist, result);
	}

	@Test
	void testGetCarsByModel() {
		List<Car>list = new ArrayList<Car>();
		Car c= new Car();
		c.setCarId(36);
		c.setBrand("Audi");
		c.setModel("R8");
		c.setVariant("High milege");
		c.setRegistrationYear(LocalDate.parse("2021-01-12"));
		c.setRegistrationState("Kerala");
		c.setCustomers(new Customer(19,"Avinash Ram","avinash@gmail.com","9840712511",LocalDate.parse("2000-12-01"),"A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012));
		list.add(c);
		List<CarDTO> dtolist=CarUtils.convertToCarDtoList(list);
		List<CarDTO> getModel=service.getCarsByModel("R8");
		assertEquals(dtolist,getModel);
		
		
	}

	@Test
	void testGetCarsByBrand() {
		List<Car>list = new ArrayList<Car>();
		Car c= new Car();
		c.setCarId(36);
		c.setBrand("Audi");
		c.setModel("R8");
		c.setVariant("High milege");
		c.setRegistrationYear(LocalDate.parse("2021-01-12"));
		c.setRegistrationState("Kerala");
		c.setCustomers(new Customer(19,"Avinash Ram","avinash@gmail.com","9840712511",LocalDate.parse("2000-12-01"),"A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012));
		list.add(c);
		List<CarDTO> dtolist=CarUtils.convertToCarDtoList(list);
		List<CarDTO> getBrand=service.getCarsByBrand("Audi");
		assertEquals(dtolist,getBrand);
	}

}

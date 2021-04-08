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
import com.cg.cars.exception.CarServiceException;
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
	void testAddCar() throws CarServiceException {
		Car c= new Car();
		c.setCarId(4);
		c.setBrand("Audi");
		c.setModel("R8");
		c.setVariant("High milege");
		c.setRegistrationYear(LocalDate.parse("2021-01-12"));
		c.setRegistrationState("Kerala");
		c.setCustomers(new Customer(1,"Avinash","avinash@gmail.com","9840712511",LocalDate.parse("2000-12-01"),"A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012));
		Car addcar=CarUtils.convertToCar(service.addCar(c));
		c.setCarId(addcar.getCarId());
		c.setCustomers(addcar.getCustomers());
		assertEquals(c, addcar);
	}

	@Disabled
	@Test
	void testRemoveCar() throws CarServiceException {
		Car c= new Car();
		c.setCarId(8);
		c.setBrand("Audi");
		c.setModel("R8");
		c.setVariant("High milege");
		c.setRegistrationYear(LocalDate.parse("2021-01-12"));
		c.setRegistrationState("Kerala");
		c.setCustomers(new Customer(7,"Avinash","avinash@gmail.com","9840712511",LocalDate.parse("2000-12-01"),"A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012));
		Car carrem=CarUtils.convertToCar(service.removeCar(8));	
		assertEquals(c, carrem);
	}

	@Disabled
	@Test
	void testUpdateCar() throws CarServiceException {
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

	@Disabled
	@Test
	void testGetCar() throws CarServiceException {
		CarDTO getcarId=service.getCar(36);
		assertEquals("Audi", getcarId.getBrand());
	}

	@Disabled
	@Test
	void testGetAllCars() throws CarServiceException {
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

	@Disabled
	@Test
	void testGetCarsByModel() throws CarServiceException {
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

	@Disabled
	@Test
	void testGetCarsByBrand() throws CarServiceException {
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

	@Disabled
	@Test
	void testGetCarsByLocation() throws CarServiceException {
		List<Car>list = new ArrayList<Car>();
		Car c= new Car();
		c.setCarId(8);
		c.setBrand("Audi");
		c.setModel("R8");
		c.setVariant("High milege");
		c.setRegistrationYear(LocalDate.parse("2021-01-12"));
		c.setRegistrationState("Kerala");
		c.setCustomers(new Customer(1,"Avinash","avinash@gmail.com","9840712511",LocalDate.parse("2000-12-01"),"A2", "12 th", "Anna Nagar", "Chennai","Tamil Nadu",600012));
		list.add(c);
		List<CarDTO> dtolist=CarUtils.convertToCarDtoList(list);
		List<CarDTO> getLoc=service.getCarsByLocation("Kerala");
		assertEquals(dtolist,getLoc);
	}
}

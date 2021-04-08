package com.cg.cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cars.entities.Address;
import com.cg.cars.entities.Appointment;
import com.cg.cars.entities.Customer;
import com.cg.cars.exception.AppointmentExceptions;
import com.cg.cars.exception.AppoitnmentNotFoundException;
import com.cg.cars.exception.CustomerServiceException;
import com.cg.cars.model.AppointmentDTO;
import com.cg.cars.model.CustomerDTO;
import com.cg.cars.service.IAppointmentService;
import com.cg.cars.service.ICustomerService;
import com.cg.cars.service.IPaymentService;
import com.cg.cars.utils.AppointmentUtils;
import com.cg.cars.utils.CustomerUtils;

@SpringBootTest
class AppointmentServiceImplTest {

	@Autowired
	IAppointmentService service;

	@Autowired
	IPaymentService paymentService;

	@Autowired
	ICustomerService customerService;

	private int insertedAppointmentID;
	private long insertedCustomerID;
	@Disabled
	@Test
	void testAddAppointment() throws AppointmentExceptions{
		Address address=new Address("12", "My street", "Area 7", "Madurai", "Tamil Nadu", 123456);
		CustomerDTO customerDTO=customerService.addCustomer(new Customer(12, "Vivek", "sampletecmast@mail.com", "1454789100",LocalDate.parse("2000-05-01") , address));
		Appointment appointment=new Appointment(1, "Location ", "Talk", LocalDate.parse("2021-04-25"), LocalTime.parse("05:01:05"), CustomerUtils.convertToCustomer(customerDTO),null);
		AppointmentDTO dto=service.addAppointment(appointment);
		appointment.setAppointmentId(dto.getAppointmentId());
		this.insertedAppointmentID=dto.getAppointmentId();
		this.insertedCustomerID=customerDTO.getUserId();
		assertEquals(dto, AppointmentUtils.convertToAppointmentDTO(appointment));
	}


	@Disabled
	@Test
	void testRemoveAppointment() throws AppoitnmentNotFoundException {
		CustomerDTO customerDTO=customerService.getCustomer(40);
		AppointmentDTO dto=new AppointmentDTO(41, "Location ", "Talk", "2021-04-25", "05:01:05", customerDTO, null);
		AppointmentDTO result=service.removeAppointment(41);
		assertEquals(dto, result);
	}

	@Disabled
	@Test
	void testGetAppointment() throws AppoitnmentNotFoundException {
		CustomerDTO customerDTO=customerService.getCustomer(40);
		AppointmentDTO dto=new AppointmentDTO(41, "Location ", "Talk", "2021-04-25", "05:01:05", customerDTO, null);
		AppointmentDTO result=service.getAppointment(41);
		assertEquals(dto, result);
	}
	@Disabled
	@Test
	void testGetAllAppointments() {
		CustomerDTO customerDTO=customerService.getCustomer(9);
		AppointmentDTO dto=new AppointmentDTO(10, "Location", "Talk", "2021-04-25", "05:01:05", customerDTO, null);
		List<AppointmentDTO> list=new ArrayList<AppointmentDTO>();
		list.add(dto);
		List<AppointmentDTO> result=service.getOpenAppointments();
		list.sort(null);
		result.sort(null);
		assertIterableEquals(list, result);
	}
	@Disabled
	@Test
	void testGetOpenAppointments() {
		CustomerDTO customerDTO=customerService.getCustomer(29);
		AppointmentDTO dto=new AppointmentDTO(10, "Locationnew", "Talk", "2021-04-25", "05:01:05", customerDTO, null);
		List<AppointmentDTO> list=new ArrayList<AppointmentDTO>();
		list.add(dto);
		List<AppointmentDTO> result=service.getOpenAppointments();
		list.sort(null);
		result.sort(null);
		assertIterableEquals(list, result);
		//org.junit.jupiter.api.Assertions.assertThrows(CustomerServiceException.class,)
	}
	

	@Disabled
	@Test
	void testUpdateAppointment() throws AppointmentExceptions {
		CustomerDTO customerDTO=customerService.getCustomer(9);
		AppointmentDTO dto=new AppointmentDTO(10, "LocationNew", "Talk", "2021-04-25", "05:01:05", customerDTO, null);
		AppointmentDTO updated=service.updateAppointment(10, AppointmentUtils.convertToAppointment(dto));
		assertEquals(dto, updated);
	}

}

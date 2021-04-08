package com.cg.cars;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cars.entities.Appointment;
import com.cg.cars.entities.Customer;
import com.cg.cars.service.ICustomerService;
@SpringBootTest
class AppointmentServiceImplTest {
	static Appointment appointment = new Appointment();
	@Autowired
	private ICustomerService service;

	@Test
	void testAddAppointment() {
		Appointment appoint=new Appointment();
		appoint.setAppointmentId(1);
		appoint.setInspectionType("Delivery");
		appoint.setLocation("Pune");
		appoint.setPreferredDate(LocalDate.parse("2021-05-01"));
		appoint.setPreferredTime(LocalTime.parse("10:00:00"));
		appoint.setCustomer(new Customer(19,"Monisha","monisha@gmail.com","9840712500",LocalDate.parse("2000-01-24"),"D2", "#3rd ", "Anna Nagar", "Chennai","Tamil Nadu",60001));
		//appoint.setPayment(new Payment(38, "Card", "Pending", 12, LocalDate.parse("2030-02-28"), "Master", "1234567898765431", 121));
	}

	@Test
	void testRemoveAppointment() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAppointment() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllAppointments() {
		fail("Not yet implemented");
	}

	@Test
	void testGetOpenAppointments() {
		fail("Not yet implemented");
	}

	@Test
	void testIsValidAppointment() {
		fail("Not yet implemented");
	}

	

}

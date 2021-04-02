package com.cg.cars.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	private long appointmentId;
	private String location;
	private String inspectionType;
	private LocalDate preferredDate;
	private LocalTime preferredTime;
	private Customer customer;
	private Payment payment;

}

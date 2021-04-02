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
	/**
	 * @return the appointmentId
	 */
	public long getAppointmentId() {
		return appointmentId;
	}
	/**
	 * @param appointmentId the appointmentId to set
	 */
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the inspectionType
	 */
	public String getInspectionType() {
		return inspectionType;
	}
	/**
	 * @param inspectionType the inspectionType to set
	 */
	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}
	/**
	 * @return the preferredDate
	 */
	public LocalDate getPreferredDate() {
		return preferredDate;
	}
	/**
	 * @param preferredDate the preferredDate to set
	 */
	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}
	/**
	 * @return the preferredTime
	 */
	public LocalTime getPreferredTime() {
		return preferredTime;
	}
	/**
	 * @param preferredTime the preferredTime to set
	 */
	public void setPreferredTime(LocalTime preferredTime) {
		this.preferredTime = preferredTime;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}
	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}

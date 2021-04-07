package com.cg.cars.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;

	@Column(name = "location", nullable = false)
	@NotBlank(message = "Location cannot be blank")
	private String location;

	@Column(name = "inspectionType", nullable = false)
	@NotBlank(message = "Inspection type cannot be blank")
	private String inspectionType;

	@Column(name = "preferredDate", nullable = false)
	@NotBlank(message = "Preferred Date cannot be blank")
	private LocalDate preferredDate;

	@Column(name = "preferredTime", nullable = false)
	@NotBlank(message = "Preferred Time cannot be blank")
	private LocalTime preferredTime;

	@ManyToOne(targetEntity = Customer.class, optional = false)
	@JoinColumn(nullable = false)
	@NotBlank(message = "Customer cannot be blank")
	private Customer customer;

	@OneToOne(targetEntity = Payment.class)
	@JoinColumn(name = "paymentId")
	@NotBlank(message = "Payment cannot be blank")
	private Payment payment;

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	public LocalDate getPreferredDate() {
		return preferredDate;
	}

	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}

	public LocalTime getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(LocalTime preferredTime) {
		this.preferredTime = preferredTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Appointment(long appointmentId, String location, String inspectionType, LocalDate preferredDate,
			LocalTime preferredTime, Payment payment) {
		super();
		this.appointmentId = appointmentId;
		this.location = location;
		this.inspectionType = inspectionType;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", customer=" + customer + ", inspectionType="
				+ inspectionType + ", location=" + location + ", payment=" + payment + ", preferredDate="
				+ preferredDate + ", preferredTime=" + preferredTime + "]";
	}

	public Appointment() {
	}

}

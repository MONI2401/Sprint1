package com.cg.cars.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.time.LocalTime;
import com.cg.cars.entities.Customer;
import com.cg.cars.entities.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class AppointmentDTO {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;

	private String location;

	private String inspectionType;

	private Date preferredDate;

	private LocalTime preferredTime;

	@Autowired
	private Customer customer;

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

	public Date getPreferredDate() {
		return preferredDate;
	}

	public void setPreferredDate(Date preferredDate) {
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

	public AppointmentDTO(long appointmentId, String location, String inspectionType, Date preferredDate,
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
		return "Appointment [Appointment Id=" + this.appointmentId + " location=" + this.location + " preferred date="
				+ this.preferredDate.toString() + " preferred time=" + this.preferredTime.toString() + " ]";
	}

	public AppointmentDTO() {
	}
}

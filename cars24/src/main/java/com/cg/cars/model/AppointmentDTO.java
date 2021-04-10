package com.cg.cars.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class AppointmentDTO implements Comparable<AppointmentDTO> {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;

	private String location;

	private String inspectionType;

	private String preferredDate;

	private String preferredTime;

	private CustomerDTO customer;

	private PaymentDTO payment;

	/**
	 * @return the appointmentId
	 */
	public int getAppointmentId() {
		return appointmentId;
	}

	/**
	 * @param appointmentId the appointmentId to set
	 */
	public void setAppointmentId(int appointmentId) {
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
	public String getPreferredDate() {
		return preferredDate;
	}

	/**
	 * @param preferredDate the preferredDate to set
	 */
	public void setPreferredDate(String preferredDate) {
		this.preferredDate = preferredDate;
	}

	/**
	 * @return the preferredTime
	 */
	public String getPreferredTime() {
		return preferredTime;
	}

	/**
	 * @param preferredTime the preferredTime to set
	 */
	public void setPreferredTime(String preferredTime) {
		this.preferredTime = preferredTime;
	}

	@Override
	public String toString() {
		return "Appointment [Appointment Id=" + this.appointmentId + " location=" + this.location + " preferred date="
				+ this.preferredDate.toString() + " preferred time=" + this.preferredTime.toString() + " ]";
	}

	/**
	 * 
	 */
	public AppointmentDTO() {
	}

	/**
	 * @return the customer
	 */
	public CustomerDTO getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	/**
	 * @return the payment
	 */
	public PaymentDTO getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(PaymentDTO payment) {
		this.payment = payment;
	}

	@Override
	public int compareTo(AppointmentDTO o) {
		int nullableResults = 0;
		if (!(o.payment == null && this.payment == null))
			nullableResults = o.payment.compareTo(this.payment);
		else if (o.payment == null && this.payment == null)
			nullableResults = 0;
		else
			nullableResults = -1;
		return this.appointmentId - o.appointmentId + this.inspectionType.compareTo(o.inspectionType)
				+ this.location.compareTo(o.location) + this.preferredDate.compareTo(o.preferredDate)
				+ this.preferredTime.compareTo(o.preferredTime) + this.customer.compareTo(o.customer) + nullableResults;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appointmentId;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((inspectionType == null) ? 0 : inspectionType.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((preferredDate == null) ? 0 : preferredDate.hashCode());
		result = prime * result + ((preferredTime == null) ? 0 : preferredTime.hashCode());
		return result;
	}

	/**
	 * @param appointmentId
	 * @param location
	 * @param inspectionType
	 * @param localDate
	 * @param localTime
	 * @param customer
	 * @param payment
	 */
	public AppointmentDTO(int appointmentId, String location, String inspectionType, String localDate, String localTime,
			CustomerDTO customer, PaymentDTO payment) {
		this.appointmentId = appointmentId;
		this.location = location;
		this.inspectionType = inspectionType;
		this.preferredDate = localDate;
		this.preferredTime = localTime;
		this.customer = customer;
		this.payment = payment;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointmentDTO other = (AppointmentDTO) obj;
		if (appointmentId != other.appointmentId)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (inspectionType == null) {
			if (other.inspectionType != null)
				return false;
		} else if (!inspectionType.equals(other.inspectionType))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (preferredDate == null) {
			if (other.preferredDate != null)
				return false;
		} else if (!preferredDate.equals(other.preferredDate))
			return false;
		if (preferredTime == null) {
			if (other.preferredTime != null)
				return false;
		} else if (!preferredTime.equals(other.preferredTime))
			return false;
		return true;
	}

}

package com.cg.cars.entities;

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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="Appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;

	@Column(name="location",nullable=false)
	private String location;

	@Column(name="inspectionType",nullable = false)
	private String inspectionType;

	@Column(name="preferredDate",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date preferredDate;

	@Column(name="preferredTime",nullable = false)
	private LocalTime preferredTime;

	@ManyToOne(targetEntity = Customer.class, optional = false,cascade = CascadeType.REFRESH)
	@JoinColumn(table = "userId",nullable = false)
	private Customer customer;

	@OneToOne(targetEntity = Payment.class,cascade = CascadeType.ALL,optional = false,mappedBy = "paymentId")
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
	public Date getPreferredDate() {
		return preferredDate;
	}
	/**
	 * @param preferredDate the preferredDate to set
	 */
	public void setPreferredDate(Date preferredDate) {
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
	/**
	 * @param appointmentId
	 * @param location
	 * @param inspectionType
	 * @param preferredDate
	 * @param preferredTime
	 * @param customer
	 * @param payment
	 */
	public Appointment(long appointmentId, String location, String inspectionType, Date preferredDate,
			LocalTime preferredTime,  Payment payment) {
				super();
		this.appointmentId = appointmentId;
		this.location = location;
		this.inspectionType = inspectionType;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
		this.payment = payment;
	}

	@Override
	public String toString()
	{
		return "Appointment [Appointment Id="+this.appointmentId+" location="+this.location+" preferred date="+this.preferredDate.toString() + " preferred time="+this.preferredTime.toString()+ " ]";
	}
}
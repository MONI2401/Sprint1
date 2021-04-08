package com.cg.cars.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import com.cg.cars.entities.Customer;
import com.cg.cars.entities.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class AppointmentDTO {


    @GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;

	private String location;

	private String inspectionType;
	
	private String preferredDate;

	private String preferredTime;

    @Autowired
	private Customer customer;

	private Payment payment;

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
     * 
     */

    /**
     * @param appointmentId
     * @param location
     * @param inspectionType
     * @param preferredDate
     * @param preferredTime
     * @param customer
     * @param payment
     */
    public AppointmentDTO(int appointmentId, String location, String inspectionType, String preferredDate,
            String preferredTime,  Payment payment) {
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

    /**
     * 
     */
    public AppointmentDTO() {
    }
}

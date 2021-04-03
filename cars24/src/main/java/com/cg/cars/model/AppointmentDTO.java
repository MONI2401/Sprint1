package com.cg.cars.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.time.LocalTime;
import com.cg.cars.entities.Customer;
import com.cg.cars.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDTO {


    @GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;

	private String location;

	private String inspectionType;
	
	private Date preferredDate;

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
     * 
     */
    public AppointmentDTO() {
        super();
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
    public AppointmentDTO(long appointmentId, String location, String inspectionType, Date preferredDate,
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

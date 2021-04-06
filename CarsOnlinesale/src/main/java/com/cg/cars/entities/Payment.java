package com.cg.cars.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long paymentId;
	
	@NotBlank(message = "Type cannot be blank")
	@Column(name="type")
	private String type;
	
	@NotBlank(message="Status cannot be blank")
	@Column(name="status")
	private String status;

   @OneToOne(targetEntity = Appointment.class)
    @JoinColumn(name="appointmentId")
    private Appointment appointment;

	
	@ManyToOne(targetEntity = Card.class)
	@JoinColumn(nullable = false)
	private Card card;
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Card getCards() {
		return card;
	}
	public void setCards(Card cards) {
		this.card = cards;
	}
	public Payment() {
		super();
	}
	
	public Payment(long paymentId,String type,String status, Card card) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card=card;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}
    /**
     * @return the appointment
     */
    public Appointment getAppointment() {
        return appointment;
    }
    /**
     * @param appointment the appointment to set
     */
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    /**
     * @param paymentId
     * @param type
     * @param status
     * @param appointment
     * @param cards
     */
    public Payment(long paymentId, @NotBlank(message = "Type cannot be blank") String type,
            @NotBlank(message = "Status cannot be blank") String status, Appointment appointment, Card card) {
        this.paymentId = paymentId;
        this.type = type;
        this.status = status;
        this.appointment = appointment;
        this.card=card;
    }
	
	
	
	

}
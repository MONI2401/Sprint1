package com.cg.cars.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long paymentId;

	@NotBlank(message = "Type cannot be blank")
	@Column(name = "type")
	private String type;

	@NotBlank(message = "Status cannot be blank")
	@Column(name = "status")
	private String status;

	@OneToOne(targetEntity = Appointment.class)
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;

	@OneToMany(targetEntity = Card.class, fetch = FetchType.EAGER, mappedBy = "id")
	private List<Card> cards;

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

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public Payment() {
		super();
	}

	public Payment(long paymentId, String type, String status, Card card) {
		super();
		this.cards = new ArrayList<Card>();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		cards.add(card);
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + cards + "]";
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Payment(long paymentId, String type, String status, Appointment appointment, List<Card> cards) {
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.appointment = appointment;
		this.cards = cards;
	}

}

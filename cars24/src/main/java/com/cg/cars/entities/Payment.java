package com.cg.cars.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "payment")
public class Payment implements Comparable<Payment> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paymentId")
	private long paymentId;

	@Column(name = "type", nullable = false)
	@NotBlank(message = "Payment type Should Not Be Blank")
	private String type;

	@Column(name = "status", nullable = false)
	@NotBlank(message = "Payment Status Should Not Be Blank")
	private String status;

	@ManyToOne(targetEntity = Card.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "card_id", referencedColumnName = "id")
	private Card card;

	public Payment() {
		super();
	}

	public Payment(long paymentId, String type, String status, long id, String cardName, String cardNumber,
			LocalDate cardExpiry, int cvv) {
		super();
		this.card = new Card(id, cardName, cardNumber, cardExpiry, cvv);
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;

	}

	public Payment(long paymentId, String type, String status, Card card) {
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card = card;
	}

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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}

	@Override
	public int compareTo(Payment o) {
		return (int) (this.paymentId - o.paymentId) + this.type.compareTo(o.type) + this.status.compareTo(o.status)
				+ this.card.compareTo(o.card);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + (int) (paymentId ^ (paymentId >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (card == null) {
			if (other.card != null)
				return false;
		} else if (!card.equals(other.card))
			return false;
		if (paymentId != other.paymentId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
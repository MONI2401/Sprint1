package com.cg.cars.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.cg.cars.entities.Card;

@Component
public class PaymentDTO implements Comparable<PaymentDTO> {

	private long paymentId;

	private String type;

	private String status;

	private Card card;

	public PaymentDTO() {
		super();
	}

	public PaymentDTO(long paymentId, String type, String status, long id, String cardName, String cardNumber,
			LocalDate cardExpiry, int cvv) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card = new Card(id, cardName, cardNumber, cardExpiry, cvv);
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
	public int compareTo(PaymentDTO o) {
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
		PaymentDTO other = (PaymentDTO) obj;
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
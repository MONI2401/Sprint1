package com.cg.cars.model;

<<<<<<< HEAD
public class PaymentDTO {
=======
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;


import org.springframework.stereotype.Component;

import com.cg.cars.entities.Card;
@Component 
public class PaymentDTO {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private String type;
	private String status;
	private Card card;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
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
	
	
	public PaymentDTO(int paymentId, String type, String status, Card card) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card = card;
	}
	
	public PaymentDTO() {
		super();
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}
	
	
>>>>>>> refs/remotes/origin/avinash

}

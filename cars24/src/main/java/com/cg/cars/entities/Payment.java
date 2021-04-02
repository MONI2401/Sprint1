package com.cg.cars.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long paymentId;
	
	@Column(name="type",nullable=false,length=10)
	private String type;
	
	@Column(name="status",nullable=false,length=15)
	private String status;
	
	@OneToMany(targetEntity = Card.class,fetch=FetchType.EAGER,mappedBy = "id", cascade = CascadeType.REFRESH)
	@JoinColumn(name="id",nullable=true)
	private List<Card> card;
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
	/*
	 * public Card getCard() { return card; } public void setCard(Card card) {
	 * this.card = card; }
	 */
	public Payment() {
		super();
	}
	public Payment(long paymentId, String type, String status) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}
	
	

}

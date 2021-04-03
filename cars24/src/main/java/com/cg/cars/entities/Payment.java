package com.cg.cars.entities;

import java.util.ArrayList;
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
import javax.validation.constraints.NotBlank;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	
	@NotBlank(message = "Type cannot be blank")
	@Column(name="type")
	private String type;
	
	@NotBlank(message="Status cannot be blank")
	@Column(name="status")
	private String status;
	
	@OneToMany(targetEntity = Card.class,fetch=FetchType.EAGER,mappedBy = "id", cascade = CascadeType.REFRESH)
	@JoinColumn(name="id")
	private List<Card> cards;
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
	
	
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public Payment() {
		super();
	}
	
	public Payment(int paymentId,String type,String status, Card card) {
		super();
		this.cards=new ArrayList<Card>();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		cards.add(card);
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + cards + "]";
	}
	
	
	
	

}

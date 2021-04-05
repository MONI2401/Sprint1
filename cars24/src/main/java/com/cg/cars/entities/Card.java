package com.cg.cars.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Card")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank(message = "Card name cannot be blank")
	@Column(name = "cardname", length = 25)
	private String cardName;

	@NotBlank(message = "Card number cannot be blank")
	@Column(name = "cardnumber", unique = true, length = 16)
	private String cardNumber;

	@NotBlank(message = "Card expiry LocalDate cannot be blank")
	@Column(name = "cardexpiryLocalDate")

	private LocalDate cardExpiry;

	@NotBlank(message = "Card cvv cannot be blank")
	@Column(name = "cvv", length = 3, unique = true)
	private int cvv;

	@ManyToOne(targetEntity = Payment.class, fetch = FetchType.EAGER)
	private Payment payment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Card(int id, String cardName, String cardNumber, LocalDate cardExpiry, int cvv, Payment payment) {
		super();
		this.id = id;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
		this.payment = payment;
	}

	public Card() {
		super();
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", cardExpiry=" + cardExpiry
				+ ", cvv=" + cvv + "]";
	}

}

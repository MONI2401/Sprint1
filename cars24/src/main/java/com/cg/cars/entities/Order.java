package com.cg.cars.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Order")

public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderId;
	
	@Column(name="amount",nullable = true)
	private double amount;
	
	@Column(name="billingDate",nullable = true)
    private LocalDate billingDate;
	
	@ManyToOne(targetEntity = Customer.class, optional = false,cascade = CascadeType.REFRESH)
	@JoinColumn(table = "userId",nullable = true)
	private Customer customer;
	
	@OneToOne(targetEntity = Payment.class,cascade = CascadeType.ALL,optional = true,mappedBy = "paymentId")
	private Payment payment;
	
	public long getOrderId() {
		return (long) orderId;
	}

	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	
	public double getAmount() {
		return amount;
	}

	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate( LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Order(long orderId, double amount, LocalDate billingDate, Customer customer, Payment payment)
    {
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate =billingDate;
		this.customer = customer;
		this.payment = payment;
	}

}
	
	

package com.cg.cars.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderId;
	
	@Column(name="amount",nullable = false)
	private double amount;
	
	@Column(name="billingDate",nullable = false)
    private LocalDate billingDate;
	
	@ManyToOne(targetEntity = Customer.class,optional = false)
	private Customer customer;
	
	@OneToOne(targetEntity = Payment.class)
    private Payment paymentMethod;
	
	
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
	
	public Payment getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(Payment paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public Order(long orderId, double amount, LocalDate billingDate, Customer customer, Payment payment)
    {
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate =billingDate;
		this.customer = customer;
		
	}

}
	
	

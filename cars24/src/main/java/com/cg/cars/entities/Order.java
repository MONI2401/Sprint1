package com.cg.cars.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="Order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	
	@NotBlank(message = "Amount Should NOT be Blank")
	@Column(name="amount",nullable = true)
	private double amount;


	@NotBlank(message = "BillingDate Should NOT be Blank")
	@Column(name="billingDate",nullable = true)
    @Temporal(TemporalType.DATE)
    private Date billingDate;

	
	
	
	@ManyToOne
	@JoinColumn(name = "userId",nullable = true)

	private List<Customer> customers;


    @NotBlank(message = "PaymentMethod Should NOT be Blank")
	@Column(name="paymentMethod",nullable = true)
     private String paymentMethod;

	

	public long getOrderId() {
		return (long) orderId;
	}

	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	
	public double getAmount() {
		return amount;
	}

	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	public Date getBillingDate() {
		return billingDate;
	}
	public void setBillingDate( Date billingDate) {
		this.billingDate = billingDate;
	}
	
	public List<Customer> getCustomer() {
		return customers;
	}
	
	public void setCustomer(List<Customer> customer) {
		this.customers = customer;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public Order(long orderId, double amount, Date billingDate, List<Customer> customer, String paymentMethod)
    {
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate =billingDate;
		this.customers = customer;
		this.paymentMethod = paymentMethod;
	}

}
	
	
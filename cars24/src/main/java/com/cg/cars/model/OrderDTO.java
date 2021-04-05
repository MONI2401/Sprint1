package com.cg.cars.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Component;

import com.cg.cars.entities.Address;
import com.cg.cars.entities.Customer;

@Component
public class OrderDTO {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	private Double amount;
	private Date billingDate;
	private List<Customer> customer;
    private String paymentMethod;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate){
		this.billingDate = billingDate;
	}
	 
                 

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

                 public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod){
		this.paymentMethod = paymentMethod;
	}


	public OrderDTO(long orderId, Double amount, Date billingDate, Customer cus, String paymentMethod) {
		super();
		this.customer=new ArrayList<Customer>();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		customer.add(cus);
        this.paymentMethod =paymentMethod;
	}

	public OrderDTO() {
		super();
	}

	@Override
	public String toString() {
		return "Order[orderId=" + orderId + ", amount=" + amount+ ", billingDate=" + billingDate + ", customer=" + customer + ", paymentMethod=" + paymentMethod + "]";

}}
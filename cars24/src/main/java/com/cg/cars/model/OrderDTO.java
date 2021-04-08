package com.cg.cars.model;

import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Component;

import com.cg.cars.entities.Customer;
import com.cg.cars.entities.Payment;

@Component
public class OrderDTO implements Comparable<OrderDTO>{

	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	private Double amount;
	private LocalDate billingDate;
	private Customer customer;
	private Payment paymentMethod;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
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

	public OrderDTO(long orderId, Double amount, LocalDate billingLocalDate, Customer cus, Payment paymentMethod) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingLocalDate;
		this.customer = cus;
		this.paymentMethod = paymentMethod;
	}

	public OrderDTO() {
		super();
	}

	@Override
	public String toString() {
		return "Order[orderId=" + orderId + ", amount=" + amount + ", billingLocalDate=" + billingDate + ", customer="
				+ customer + ", paymentMethod=" + paymentMethod + "]";

	}

	@Override
	public int compareTo(OrderDTO o) {
		return (int)(this.orderId-o.orderId + this.amount-o.amount + this.billingDate.compareTo(o.billingDate)+
				this.customer.compareTo(o.customer)+this.paymentMethod.compareTo(o.paymentMethod));
	}
	@Override
	public boolean equals(Object o) {
		OrderDTO p = (OrderDTO) o;
		return this.compareTo(p) == 0;
	}

}
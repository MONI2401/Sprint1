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
@Table(name = "Orders")
public class Order  implements Comparable<Order>
{
	public Order() {
		super();

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;

	@Column(name = "amount", nullable = false)
	private double amount;

	@Column(name = "billingDate", nullable = false)
	private LocalDate billingDate;

	@ManyToOne(targetEntity = Customer.class, optional = false)
	private Customer customer;

	@OneToOne(targetEntity = Payment.class)
	private Payment paymentMethod;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
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

	public Order(long orderId, double amount, LocalDate billingDate, Customer customer, Payment paymentMethod) {
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = customer;
        this.paymentMethod = paymentMethod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((billingDate == null) ? 0 : billingDate.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + (int) (orderId ^ (orderId >>> 32));
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
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
		Order other = (Order) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (billingDate == null) {
			if (other.billingDate != null)
				return false;
		} else if (!billingDate.equals(other.billingDate))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderId != other.orderId)
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		return true;
	}

	@Override
	public int compareTo(Order o) {

		
	return (int) (this.orderId - o.orderId + this.amount-o.amount +this.billingDate.compareTo(o.billingDate)+
			this.customer.compareTo(o.customer)+this.paymentMethod.compareTo(o.paymentMethod));

	}			

}
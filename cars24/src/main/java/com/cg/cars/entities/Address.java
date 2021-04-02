package com.cg.cars.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import java.util.List;

@Entity
@Table(name="Address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;

	@NotNull()
	@Column(name="doorno",nullable = false)
	private String doorNo;

	@NotNull()
	@Column(name="street",nullable = false)
	private String street;

	@Column(name="area")
	private String area;

	@NotNull()
	@Column(name="city",nullable=false)
	private String city;

	@NotNull()
	@Column(name="state",nullable = false)
	private String state;

	@NotNull()
	@Column(name="pincode",nullable=false)
	private int pincode;

	@ManyToMany(targetEntity = Customer.class,fetch = FetchType.EAGER, mappedBy = "userId",cascade = CascadeType.REFRESH)
	@JoinColumn(name="userId",nullable=false)
	private List<Customer> customers;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	
	public List<Customer> getCustomers() {
		return customers;
	}

	
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


}
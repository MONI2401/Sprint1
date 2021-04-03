package com.cg.cars.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;

	@NotBlank(message = "Customer Door No Should NOT be Blank")
	@Column(name="doorno")
	private String doorNo;

	@NotBlank(message = "Street name Should NOT be Blank")
	@Column(name="street")
	private String street;

	@Column(name="area")
	private String area;

	@NotBlank(message = "Area name Should NOT be Blank")
	@Column(name="city",nullable=false)
	private String city;

	@NotBlank(message = "Customer name Should NOT be Blank")
	@Column(name="state",nullable = false)
	private String state;

	@NotBlank(message = "Pincode Should NOT be Blank")
	@Column(name="pincode",nullable=false)
	private int pincode;

	@ManyToMany(targetEntity = Customer.class,fetch = FetchType.EAGER, mappedBy = "userId",cascade = CascadeType.REFRESH)
	@JoinColumn(name="userId",nullable=false)
	private List<Customer> customers;

	private ArrayList<Customer> customer;


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


	public void addCustomer(Customer customer)	
	{
		this.customers.add(customer);
	}
	 


	
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", doorNo=" + doorNo + ", street=" + street + ", area=" + area
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", customers=" + customers + "]";
	}


	public Address(int addressId, String doorNo,
			 String street, String area,
			String city,
			 String state,
			 int pincode, Customer customers) {
		super();
		this.customer=new ArrayList<Customer>();
		this.addressId = addressId;
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		 customer.add(customers);
	}


	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}



}

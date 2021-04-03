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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@NotBlank(message = "Customer name Should NOT be Blank")
	@Column(name="name",length=50)
	private String name;

	@NotBlank(message = "Customer Mail ID Should NOT be Blank")
	@Column(name="email",unique=true,length = 255)
	private String email;

	@NotBlank(message = "Customer Phone number Should NOT be Blank")
	@Column(name="contactno",unique=true,length = 10)
	private String contactNo;

	@NotBlank(message = "Customer DOB Should NOT be Blank")
	@Column(name="dob")
	@Temporal(TemporalType.DATE)
	private  Date dob;

	
	@ManyToMany(targetEntity = Address.class,fetch = FetchType.EAGER,mappedBy = "addressId",cascade = CascadeType.REFRESH)
	@JoinColumn(name="addressId",nullable = false)
	private List<Address> addresses;


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int userId, String name, String email, String contactNo, Date dob, Address address) {
		super();
		this.addresses=new ArrayList<Address>();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		addresses.add(address);
	}
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + addresses + "]";
	}
	


}
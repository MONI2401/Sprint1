package com.cg.cars.entities;

<<<<<<< HEAD
=======
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
=======
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
>>>>>>> 8de52acba8443efac5db11077271e381491d0514


@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	
	@Column(name="name",nullable=false,length=50)
	private String name;

	@Column(name="email",nullable=false,unique=true,length = 255)
	private String email;

	@Column(name="contactno",nullable=false,unique=true,length = 10)
	private String contactNo;

	@Column(name="dob",nullable = false)
	@Temporal(TemporalType.DATE)
	private  Date dob;

	@ManyToMany(targetEntity = Address.class,fetch = FetchType.EAGER,mappedBy = "addressId",cascade = CascadeType.REFRESH)
	@JoinColumn(name="addressId",nullable = false)
<<<<<<< HEAD
	private List<Address> addresses;
=======
	private List<Address> address;
>>>>>>> 8de52acba8443efac5db11077271e381491d0514


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	// public Address getAddress() {
	// 	return address;
	// }
	// public void setAddress(Address address) {
	// 	this.address = address;
	// }
<<<<<<< HEAD
	public Customer(String userId, String name, String email, String contactNo, Date dob, Address address) {
=======
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String userId, String name, String email, String contactNo, Date dob, List<Address> address) {
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
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
		StringBuilder addressBuilder=new StringBuilder();
		for(Address address : addresses)
			addressBuilder.append(address.toString()+"\n");
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + addressBuilder.toString() + "]";
	}


}
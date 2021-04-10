package com.cg.cars.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Customers")
public class Customer implements Comparable<Customer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private long userId;

	@Column(name = "name", nullable = false, length = 20)
	@NotBlank(message = "Name should not be blank")
	private String name;

	@Column(name = "email", unique = true, nullable = false, length = 25)
	@NotBlank(message = "EmailId should not be blank")
	private String email;

	@Column(name = "contactno", unique = true, nullable = false, length = 10)
	@NotBlank(message = "ContactNo should not be blank")
	private String contactNo;

	@Column(name = "dob", nullable = false)
	@NotBlank(message = "LocalDate of Birth should not be blank")

	private LocalDate dob;

	@Embedded
	private Address address;

	public Customer(String name, String email, String contactNo, LocalDate dob, String doorNo, String street,
			String area, String city, String state, int pinCode) {
		super();
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = new Address(doorNo, street, area, city, state, pinCode);
	}

	public Customer() {
		super();
	}

	public Customer(long userId, String name, String email, String contactNo, LocalDate dob, String doorNo,
			String street, String area, String city, String state, int pinCode) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = new Address(doorNo, street, area, city, state, pinCode);
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo + ", "
				+ "dob=" + dob + ", address=" + address + "]";
	}

	public Customer(long userId, String name, String email, String contactNo, LocalDate dob, Address address) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}

	public Customer(String name, String email, String contactNo, LocalDate dob, Address address) {
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public int compareTo(Customer o) {

		return (int) (this.userId - o.userId) + this.contactNo.compareTo(o.contactNo) + this.email.compareTo(o.email)
				+ this.dob.compareTo(o.dob) + this.address.compareTo(o.address);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (contactNo == null) {
			if (other.contactNo != null)
				return false;
		} else if (!contactNo.equals(other.contactNo))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
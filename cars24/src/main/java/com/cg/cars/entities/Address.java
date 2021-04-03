package com.cg.cars.entities;

<<<<<<< HEAD
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

<<<<<<< HEAD
	/**
	 * @return the addressId
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public int getAddressId() {
		return addressId;
	}

<<<<<<< HEAD
	/**
	 * @param addressId the addressId to set
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

<<<<<<< HEAD
	/**
	 * @return the doorNo
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public String getDoorNo() {
		return doorNo;
	}

<<<<<<< HEAD
	/**
	 * @param doorNo the doorNo to set
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

<<<<<<< HEAD
	/**
	 * @return the street
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public String getStreet() {
		return street;
	}

<<<<<<< HEAD
	/**
	 * @param street the street to set
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public void setStreet(String street) {
		this.street = street;
	}

<<<<<<< HEAD
	/**
	 * @return the area
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public String getArea() {
		return area;
	}

<<<<<<< HEAD
	/**
	 * @param area the area to set
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public void setArea(String area) {
		this.area = area;
	}

<<<<<<< HEAD
	/**
	 * @return the city
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public String getCity() {
		return city;
	}

<<<<<<< HEAD
	/**
	 * @param city the city to set
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public void setCity(String city) {
		this.city = city;
	}

<<<<<<< HEAD
	/**
	 * @return the state
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public String getState() {
		return state;
	}

<<<<<<< HEAD
	/**
	 * @param state the state to set
	 */
=======

>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public void setState(String state) {
		this.state = state;
	}

<<<<<<< HEAD
	/**
	 * @return the pincode
	 */
=======
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public int getPincode() {
		return pincode;
	}

<<<<<<< HEAD
	/**
	 * @param pincode the pincode to set
	 */
=======
	
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

<<<<<<< HEAD
	/**
	 * @return the customers
	 */
=======
	
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
	public List<Customer> getCustomers() {
		return customers;
	}

<<<<<<< HEAD
	public void addCustomer(Customer customer)	
	{
		this.customers.add(customer);
	}
	 

}
=======
	
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


}
>>>>>>> 8de52acba8443efac5db11077271e381491d0514
=======
public class Address {
	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private int pincode;

}
>>>>>>> refs/remotes/origin/avinash

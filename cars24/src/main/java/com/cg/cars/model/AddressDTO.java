package com.cg.cars.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Component;

import com.cg.cars.entities.Address;

@Component
public class AddressDTO implements Comparable<AddressDTO> {
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private int pincode;

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

	public AddressDTO(String doorNo, String street, String area, String city, String state, int pincode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public AddressDTO() {
		super();

	}

	@Override
	public String toString() {
		return "AddressDTO [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + "]";
	}

	@Override
	public int compareTo(AddressDTO o) {
		
		return this.pincode-o.pincode+this.area.compareTo(o.area)+this.city.compareTo(o.city)+this.doorNo.compareTo(o.doorNo)
		+this.state.compareTo(o.state)+this.street.compareTo(o.street);
	}
	
	@Override
	public boolean equals(Object o) {
		return this.compareTo((AddressDTO)o)==0;
	}

	
}

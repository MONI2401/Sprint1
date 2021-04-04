package com.cg.cars.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Component;

@Component
public class CarDTO {
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carId;
	private String brand;
	private String model;
	private String variant;
	private Date registrationYear;
	private String registrationState;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public Date getRegistrationYear() {
		return registrationYear;
	}
	public void setRegistrationYear(Date registrationYear) {
		this.registrationYear = registrationYear;
	}
	public String getRegistrationState() {
		return registrationState;
	}
	public void setRegistrationState(String registrationState) {
		this.registrationState = registrationState;
	}
	public CarDTO(int carId, String brand, String model, String variant, Date registrationYear,
			String registrationState) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.variant = variant;
		this.registrationYear = registrationYear;
		this.registrationState = registrationState;
	}
	public CarDTO() {
		super();
		
	}
	@Override
	public String toString() {
		return "CarDTO [carId=" + carId + ", brand=" + brand + ", model=" + model + ", variant=" + variant
				+ ", registrationYear=" + registrationYear + ", registrationState=" + registrationState + "]";
	}

}

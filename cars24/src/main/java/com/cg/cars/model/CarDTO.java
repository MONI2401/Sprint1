package com.cg.cars.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Component;

import com.cg.cars.entities.Car;
import com.cg.cars.entities.Customer;

@Component
public class CarDTO implements Comparable<CarDTO> {
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long carId;
	private String brand;
	private String model;
	private String variant;
	private LocalDate registrationYear;
	private String registrationState;
	private Customer customer;

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
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

	public LocalDate getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(LocalDate registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getRegistrationState() {
		return registrationState;
	}

	@Override
	public String toString() {
		return "CarDTO [carId=" + carId + ", brand=" + brand + ", model=" + model + ", variant=" + variant
				+ ", registrationYear=" + registrationYear + ", registrationState=" + registrationState + ", customer="
				+ customer + "]";
	}

	public CarDTO(long carId, String brand, String model, String variant, LocalDate registrationYear,
			String registrationState, Customer customers) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.variant = variant;
		this.registrationYear = registrationYear;
		this.registrationState = registrationState;
		this.customer = customers;
	}

	public CarDTO() {
		super();

	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setRegistrationState(String registrationState) {
		this.registrationState = registrationState;
	}

	@Override
	public int compareTo(CarDTO o) {

		return (int) (this.carId - o.carId + this.brand.compareTo(o.brand) + this.model.compareTo(o.model)
				+ this.variant.compareTo(o.variant) + this.registrationYear.compareTo(o.registrationYear)
				+ this.registrationState.compareTo(o.registrationState) + this.customer.compareTo(o.customer));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + (int) (carId ^ (carId >>> 32));
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((registrationState == null) ? 0 : registrationState.hashCode());
		result = prime * result + ((registrationYear == null) ? 0 : registrationYear.hashCode());
		result = prime * result + ((variant == null) ? 0 : variant.hashCode());
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
		CarDTO other = (CarDTO) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (carId != other.carId)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (registrationState == null) {
			if (other.registrationState != null)
				return false;
		} else if (!registrationState.equals(other.registrationState))
			return false;
		if (registrationYear == null) {
			if (other.registrationYear != null)
				return false;
		} else if (!registrationYear.equals(other.registrationYear))
			return false;
		if (variant == null) {
			if (other.variant != null)
				return false;
		} else if (!variant.equals(other.variant))
			return false;
		return true;
	}

}

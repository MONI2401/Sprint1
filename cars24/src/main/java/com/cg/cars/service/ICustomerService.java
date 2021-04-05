package com.cg.cars.service;

import java.util.List;

import com.cg.cars.entities.Customer;
import com.cg.cars.model.CustomerDTO;

public interface ICustomerService {
	public CustomerDTO addCustomer(Customer customer);

	public CustomerDTO removeCustomer(long custId);

	public CustomerDTO updateCustomer(Customer customer);

	public CustomerDTO getCustomer(long custId);

	public List<CustomerDTO> getAllCustomers();

	public List<CustomerDTO> getCustomersByCity(String city);

}

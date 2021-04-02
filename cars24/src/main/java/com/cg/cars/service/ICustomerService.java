package com.cg.cars.service;

import java.util.List;

import com.cg.cars.entities.Customer;
import com.cg.cars.model.CustomerDTO;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public List<CustomerDTO> removeCustomer(long custId);
	public CustomerDTO updateCustomer(long custId, Customer customer);
	public List<CustomerDTO> getCustomer(long custId);
	public List<CustomerDTO> getAllCustomers(); 
	public List<CustomerDTO> getCustomersByLocation();

}

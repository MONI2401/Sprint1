package com.cg.cars.service;

import java.util.List;

<<<<<<< HEAD
import com.cg.cars.entities.Customer;
import com.cg.cars.model.CustomerDTO;

public interface ICustomerService {
	public CustomerDTO addCustomer(Customer customer);
	public CustomerDTO removeCustomer(int custId);
	public CustomerDTO updateCustomer( Customer customer);
	public CustomerDTO getCustomer(int custId);
	public List<CustomerDTO> getAllCustomers(); 
	public CustomerDTO getCustomersByCity(String city);
=======

import com.cg.cars.entities.Customer;
import com.cg.cars.model.CustomerDTO;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(long custId);
	public CustomerDTO updateCustomer(long custId, Customer customer);
	public CustomerDTO getCustomer(long custId);
	public List<CustomerDTO> getAllCustomers(); 
	public List<CustomerDTO> getCustomersByLocation();
>>>>>>> refs/remotes/origin/avinash

}

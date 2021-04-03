package com.cg.cars.dao;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cars.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	
	
	public Customer findByCity(String city);
=======
import java.util.List;

import com.cg.cars.entities.Customer;

public interface ICustomerRepository {

	public Customer addCustomer(Customer customer);
	public Customer removeCustomer(long custId);
	public Customer updateCustomer(long custId, Customer customer);
	public Customer getCustomer(long custId);
	public List<Customer> getAllCustomers(); 
	public List<Customer> getCustomersByLocation();
>>>>>>> refs/remotes/origin/avinash
}

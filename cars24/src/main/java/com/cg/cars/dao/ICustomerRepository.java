package com.cg.cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cars.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	
	
	public Customer findByCity(String city);
}

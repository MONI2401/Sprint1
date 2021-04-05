package com.cg.cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.cars.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long>{

	@Query("SELECT c FROM Customer c,Address a WHERE a.city=:city and c.address=a.addressId")
	public Customer findByCity(@Param("city") String city);
}

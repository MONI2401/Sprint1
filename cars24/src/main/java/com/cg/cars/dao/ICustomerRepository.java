package com.cg.cars.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.cg.cars.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c,Address a WHERE a.city=:city and c.address=a.addressId")
	public Customer findByCity(@Param("city") String city);



}

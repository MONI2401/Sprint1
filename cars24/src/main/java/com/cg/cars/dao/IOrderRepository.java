package com.cg.cars.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cars.entities.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Integer> {


	
}

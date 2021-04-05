package com.cg.cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cars.entities.Car;

public interface ICarRepository extends JpaRepository<Car, Long> {

	public Car findByModel(String model);

	public Car findByBrand(String brand);

}

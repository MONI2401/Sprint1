package com.cg.cars.service;

import java.util.List;

import com.cg.cars.entities.Car;
import com.cg.cars.model.CarDTO;

public interface ICarService {
	public CarDTO addCar(Car car);
	public CarDTO removeCar(int id);
	public CarDTO updateCar(Car car);
	public CarDTO getCar(int id);
	public List<CarDTO> getAllCars();
	public CarDTO getCarsByCity(String city);
	public CarDTO getCarsByModel(String model);
	public CarDTO getCarsByBrand(String brand);


	

}

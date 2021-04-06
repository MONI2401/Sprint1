package com.cg.cars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.dao.ICarRepository;
import com.cg.cars.entities.Car;
import com.cg.cars.model.CarDTO;
import com.cg.cars.utils.CarUtils;

@Service
public class CarServiceImp implements ICarService{

@Autowired
ICarRepository carrepo;

	@Override
	public CarDTO addCar(Car car) {
		Car addcar= new Car();
		addcar=carrepo.save(car);
		return CarUtils.convertToCarDto(addcar);
	}

	@Override
	public CarDTO removeCar(long id) {
		Car car=new Car();
		car=carrepo.getOne(id);
		carrepo.deleteById((long) id);
		return CarUtils.convertToCarDto(car);
	}

	@Override
	public CarDTO updateCar(Car car) {
		Car updcar= new Car();
		updcar=carrepo.save(car);
		return CarUtils.convertToCarDto(updcar);
	}

	@Override
	public CarDTO getCar(long id) {
		Car getcar= new Car();
		getcar=carrepo.findById( id).orElse(null);
		return CarUtils.convertToCarDto(getcar);
	}

	@Override
	public List<CarDTO> getAllCars() {
		List<Car> getCar=new ArrayList<Car>();
		getCar=carrepo.findAll();
		return CarUtils.convertToCarDtoList(getCar);
	}

	
	  @Override public CarDTO getCarsByCity(String city) { Car getCarCity=new
	  Car(); getCarCity= carrepo.findByCity(city); 
	  return CarUtils.convertToCarDto(getCarCity); }
	 

	@Override
	public CarDTO getCarsByModel(String model) {
		Car getCarModel=new Car();
		getCarModel= carrepo.findByModel(model);
		return CarUtils.convertToCarDto(getCarModel);
	}

	@Override
	public CarDTO getCarsByBrand(String brand) {
		Car getCarBrand=new Car();
		getCarBrand= carrepo.findByBrand(brand);
		return CarUtils.convertToCarDto(getCarBrand);
	}

}

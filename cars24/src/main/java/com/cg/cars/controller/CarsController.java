package com.cg.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.entities.Car;
import com.cg.cars.model.CarDTO;
import com.cg.cars.service.ICarService;

@RestController
@RequestMapping("/api/car")
public class CarsController {
	
		
@Autowired		
ICarService carService;

@PostMapping(path="/addCar",consumes ="application/json")
public ResponseEntity<CarDTO> addCar(@RequestBody Car car) {
CarDTO resultCar = carService.addCar(car);
return new ResponseEntity<CarDTO>(resultCar, HttpStatus.OK);
}

@DeleteMapping(path="/deleteCar/{carId}",produces="application/json")

public CarDTO removeCar(@PathVariable long carId)  
{
return carService.removeCar(carId);
}

@PutMapping("/updateCar")
public ResponseEntity<CarDTO> updateCar(@RequestBody Car car) {

CarDTO resultCar = carService.updateCar(car);
return new ResponseEntity<CarDTO>(resultCar, HttpStatus.OK);

}

@GetMapping(path="/getCarDetails/{carId}",produces = "application/json")
public ResponseEntity<CarDTO> GetCarDetails(@PathVariable long carId)  {
CarDTO resultCar = carService.getCar(carId);

return new ResponseEntity<CarDTO>(resultCar, HttpStatus.OK);

}


@GetMapping(path="/getAllCarDetails",produces = "application/json")
public ResponseEntity<List<CarDTO>> getAllCars() {

List<CarDTO> resultCar = carService.getAllCars();

return new ResponseEntity<List<CarDTO>>(resultCar, HttpStatus.OK);

}

@GetMapping("/ getCarsByCity/{city}") 
	public ResponseEntity<CarDTO> getCarsByCity(@PathVariable String city) { 
		CarDTO resultCar =carService.getCarsByCity(city); 
		return  new ResponseEntity<CarDTO>(resultCar, HttpStatus.OK);
}
@GetMapping("/ getCarsByModel/{model}") 
public ResponseEntity<CarDTO> getCarsByModel(@PathVariable String model) { 
	CarDTO resultCar =carService.getCarsByModel(model); 
	return  new ResponseEntity<CarDTO>(resultCar, HttpStatus.OK);
}
@GetMapping("/getCarsByModel/{city}") 
public ResponseEntity<CarDTO> getCarsByBrand(@PathVariable String brand) { 
	CarDTO resultCar =carService.getCarsByBrand(brand); 
	return  new ResponseEntity<CarDTO>(resultCar, HttpStatus.OK);
}




}
package com.cg.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.entities.Customer;
import com.cg.cars.exception.CustomerServiceException;
import com.cg.cars.model.CustomerDTO;
import com.cg.cars.service.CustomerServiceImp;
import com.cg.cars.service.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@PostMapping(path = "/addcustomer", consumes = "application/json")
	public ResponseEntity<CustomerDTO> insertCustomer(@RequestBody Customer customer) {
		if (CustomerServiceImp.ValidateUserContact(customer) && CustomerServiceImp.validateUserMail(customer)
				&& CustomerServiceImp.validateUserName(customer)) {
			CustomerDTO resultcustomer = customerService.addCustomer(customer);
			return new ResponseEntity<CustomerDTO>(resultcustomer, HttpStatus.OK);
		} else
			return new ResponseEntity<CustomerDTO>(new CustomerDTO(), HttpStatus.EXPECTATION_FAILED);

	}

	@DeleteMapping(path = "/deletecustomer/{id}", produces = "application/json")
	public void deleteCustomer(@PathVariable long id) throws CustomerServiceException {
		if (id != 0 && id <= 500) {
			customerService.removeCustomer(id);
		}
		throw new CustomerServiceException("ID cannot be empty or greater than 500");
	}

	@PutMapping("/updatecustomer")
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer) {
		if (CustomerServiceImp.ValidateUserContact(customer) && CustomerServiceImp.validateUserMail(customer)
				&& CustomerServiceImp.validateUserName(customer)) {

			CustomerDTO resultCustomer = customerService.updateCustomer(customer);
			return new ResponseEntity<CustomerDTO>(resultCustomer, HttpStatus.OK);
		}
		throw new CustomerServiceException("Enter Valid Customer details");
	}

	@GetMapping("/getcustomer/{id}")
	@ExceptionHandler(value = CustomerServiceException.class)
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable int id) throws CustomerServiceException {
		if (id != 0 && id <= 500) {
			CustomerDTO resultCustomer = customerService.getCustomer(id);
			return new ResponseEntity<CustomerDTO>(resultCustomer, HttpStatus.OK);
		}
		throw new CustomerServiceException("ID cannot be empty or greater than 500");
	}

	@GetMapping(path = "/allcustomers", produces = "application/json")
	public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
		List<CustomerDTO> resultCustomer = customerService.getAllCustomers();
		return new ResponseEntity<List<CustomerDTO>>(resultCustomer, HttpStatus.OK);
	}

	@GetMapping("/getcustomerCity/{city}")
	public ResponseEntity<List<CustomerDTO>> getCustomerbyCity(@PathVariable String city) {
		List<CustomerDTO> resultCustomer = customerService.getCustomersByCity(city);
		return new ResponseEntity<List<CustomerDTO>>(resultCustomer, HttpStatus.OK);
	}

}

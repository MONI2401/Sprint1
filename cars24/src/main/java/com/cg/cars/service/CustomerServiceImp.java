package com.cg.cars.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.dao.ICustomerRepository;
import com.cg.cars.entities.Customer;
import com.cg.cars.model.CustomerDTO;
import com.cg.cars.utils.CustomerUtils;

/**
*Author      : Monisha
*Date        :08-04-2021
*Description : This is Customer Service Class that provides the
 *   		   services to add a customer, remove a customer, update a customer and
 *             view a customer
**/

@Service
public class CustomerServiceImp implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepo;

	/**
	 * Description : To add the customer to the database 
	 * Input params : Customer object to be added to the database 
	 * Return Value : CustomerDTO object
	 * Exception : CustomerServiceException - It is raised when customer already exists
	 **/

	
	@Override
	public CustomerDTO addCustomer(Customer customer) {
		Customer addCustomer = new Customer();
		addCustomer = customerRepo.save(customer);
		return CustomerUtils.convertToCustomerDto(addCustomer);
	}

	/**
	 * Description : To delete the customer to the database 
	 * Input params : customer Id to be deleted from the database 
	 * Return Value : CustomerDTO object of the customer been deleted 
	 * Exception : CustomerServiceException - It is raised when customer ID doesn't exists
	 **/
	
	@Override
	public CustomerDTO removeCustomer(long custId) {

		CustomerDTO customertemp ;
		customertemp = CustomerUtils.convertToCustomerDto(customerRepo.getOne(custId));
		customerRepo.deleteById((long) custId);
		return customertemp;
	}
	
	/**
	 * Description : To update the customer details to the database 
	 * Input params :customer to be updated in the database 
	 * Return Value : CustomerDTO object of the customer been updated 
	 * Exception : CustomerServiceException - It is raised when customer doesn't exists
	 **/

	@Override
	public CustomerDTO updateCustomer(long id,Customer customer) {
		Customer updateCustomer = customerRepo.save(customer);
		return CustomerUtils.convertToCustomerDto(updateCustomer);
	}

	/**
	 * Description : To fetch the particular customer detail from the database 
	 * Input params : Customer Id to be fetched from the database 
	 * Return Value :CustomerDTO object of the customer been fetched Exception :
	 * CustomerServiceException - It is raised when customer Id doesn't exists
	 **/
	
	@Override
	public CustomerDTO getCustomer(long custId) {
		Customer getCustomer = new Customer();
		getCustomer = customerRepo.findById((long) custId).orElse(null);
		return CustomerUtils.convertToCustomerDto(getCustomer);
	}

	/**
	 * Description : To fetch all Customer details from the database 
	 * Return Value :List<CustomerDTO> object of the customers been fetched
	 *  Exception : CustomerServiceException - It is raised when Customer not found
	 **/
	
	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> getCustomer = new ArrayList<Customer>();
		getCustomer = customerRepo.findAll();
		return CustomerUtils.convertToCustomerDtoList(getCustomer);

	}

	/**
	 * Description : To fetch the Customer details belongs to particular City from the database
	 * Input params : City which details to be fetched from the database 
	 * Return Value : List<CustomerDTO> object of the customers been fetched 
	 * Exception : CustomerServiceException - It is raised when Customer not found
	 **/
	
	@Override
	public List<CustomerDTO> getCustomersByCity(String city) {
		List<Customer> getCusCity = new ArrayList<Customer>();
		getCusCity = customerRepo.findByCity(city);
		return CustomerUtils.convertToCustomerDtoList(getCusCity);

	}

	public static boolean isValidCustomer(Customer cus) {
		return validateUserMail(cus) && validateUserName(cus) && ValidateUserContact(cus);
	}

	public static boolean validateUserName(Customer cus) {

		boolean flag = false;

		if (cus.getName().length() > 3 && cus.getName().matches("^[a-zA-Z]*$")) {

			flag = true;

		}

		return flag;
	}

	public static boolean validateUserMail(Customer cus) {
		boolean flag = false;

		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		boolean result = cus.getEmail().matches(regex);
		if (result) {
			flag = true;
		}
		return flag;

	}

	public static boolean ValidateUserContact(Customer cus) {
		boolean flag = false;
		String regex = "^\\d{10}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cus.getContactNo());
		boolean result = matcher.matches();
		if (result) {
			flag = true;
		}
		return flag;
	}

}

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

@Service
public class CustomerServiceImp implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepo;

	@Override
	public CustomerDTO addCustomer(Customer customer) {
		Customer addCustomer = new Customer();
		addCustomer = customerRepo.save(customer);
		return CustomerUtils.convertToCustomerDto(addCustomer);
	}

	@Override
	public CustomerDTO removeCustomer(long custId) {

		Customer customertemp = new Customer();
		customertemp = customerRepo.getOne((long) custId);
		customerRepo.deleteById((long) custId);
		return CustomerUtils.convertToCustomerDto(customertemp);
	}

	@Override
	public CustomerDTO updateCustomer(Customer customer) {
		Customer updateCustomer = new Customer();
		updateCustomer = customerRepo.save(customer);
		return CustomerUtils.convertToCustomerDto(updateCustomer);
	}

	@Override
	public CustomerDTO getCustomer(long custId) {
		Customer getCustomer = new Customer();
		getCustomer = customerRepo.findById((long) custId).orElse(null);
		return CustomerUtils.convertToCustomerDto(getCustomer);
	}

	@Override

	public CustomerDTO getCustomersByCity(String city) {
		Customer getCustomer = new Customer();
		getCustomer = customerRepo.findByCity(city);
		return CustomerUtils.convertToCustomerDto(getCustomer);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> getCustomer = new ArrayList<Customer>();
		getCustomer = customerRepo.findAll();
		return CustomerUtils.convertToCustomerDtoList(getCustomer);

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

	public static boolean ValidateUserDOB(Customer cus) {
		boolean flag = false;
		String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher((CharSequence) cus.getDob());
		boolean result = matcher.matches();
		if (result) {
			flag = true;
		}
		return flag;
	}

}

package com.cg.cars.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.cars.entities.Customer;
import com.cg.cars.model.CustomerDTO;

public class CustomerServiceImp implements ICustomerService {

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer removeCustomer(long custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO updateCustomer(long custId, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO getCustomer(long custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> getCustomersByLocation() {
		// TODO Auto-generated method stub
		return null;
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

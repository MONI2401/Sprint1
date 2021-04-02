package com.cg.cars.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.cars.entities.Customer;
import com.cg.cars.model.CustomerDTO;

public class CustomerUtils {
		public static List<CustomerDTO> convertToCustomerDtoList(List<Customer> list){
			List<CustomerDTO> dtolist = new ArrayList<CustomerDTO>();
			for(Customer customer : list) 
				dtolist.add(convertToCustomerDto(customer));
			return dtolist;
		}
		
		public static Customer convertToCustomer(CustomerDTO dto) {
			Customer cus = new Customer();
		
				cus.setUserId(dto.getUserId());
				cus.setName(dto.getName());
				cus.setEmail(dto.getEmail());
				cus.setContactNo(dto.getContactNo());
				cus.setDob(cus.getDob());
			
				return cus;
			
		}
		
		
			
			public static CustomerDTO convertToCustomerDto(Customer cus) {
				CustomerDTO dto = new CustomerDTO();
				
				dto.setUserId(cus.getUserId());
				dto.setName(cus.getName());
				dto.setEmail(cus.getEmail());
				dto.setContactNo(cus.getContactNo());
				dto.setDob(cus.getDob());
				
				
				return dto;
			}

			
			
		

	}



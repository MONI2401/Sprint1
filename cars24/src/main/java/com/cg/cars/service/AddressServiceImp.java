package com.cg.cars.service;

import com.cg.cars.entities.Address;
import com.cg.cars.entities.Customer;

public class AddressServiceImp {

	public static boolean ValidateDoorNo(Address add) {
		boolean flag = false;
		if (add.getDoorNo().length() > 1 && add.getDoorNo().length() < 5) {
			String regex = "^[a-zA-Z0-9]+$";
			boolean result = add.getDoorNo().matches(regex);
			if (result) {
				flag = true;
			}

		}
		return flag;
	}

	public static boolean ValidateStreet(Address add) {
		boolean flag = false;

		if (add.getStreet().length() > 3 && add.getState().matches("^[a-zA-Z]*$")) {

			flag = true;

		}

		return flag;
	}

	public static boolean ValidateArea(Address add) {
		boolean flag = false;

		if (add.getArea().length() > 3 && add.getArea().matches("^[a-zA-Z]*$")) {

			flag = true;

		}

		return flag;
	}

	public static boolean ValidateCity(Address add) {
		boolean flag = false;

		if (add.getCity().length() > 3 && add.getCity().matches("^[a-zA-Z]*$")) {

			flag = true;

		}

		return flag;
	}

	public static boolean ValidateState(Address add) {
		boolean flag = false;

		if (add.getState().length() > 3 && add.getState().matches("^[a-zA-Z]*$")) {

			flag = true;

		}

		return flag;
	}

	public static boolean validatePincode(Address add) {
		boolean flag = false;
		if (add.getPincode() != 0 && add.getPincode() == 6) {
			flag = true;
		}
		return flag;

	}

}

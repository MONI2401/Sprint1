package com.cg.cars.exception;

@SuppressWarnings("serial")
public class CustomerServiceException extends RuntimeException {

	public CustomerServiceException(String msg) {
		super(msg);
	}

}

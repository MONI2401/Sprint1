package com.cg.cars.exception;

@SuppressWarnings("serial")
public class CarServiceException extends RuntimeException {
	public CarServiceException(String msg) {
		super(msg);
	}

}

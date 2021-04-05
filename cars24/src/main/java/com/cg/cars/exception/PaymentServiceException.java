package com.cg.cars.exception;

@SuppressWarnings("serial")
public class PaymentServiceException extends RuntimeException {

	public PaymentServiceException(String message) {
		super(message);
	}
}
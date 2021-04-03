package com.cg.cars.exceptions;

@SuppressWarnings("serial")
public class PaymentServiceException extends RuntimeException {

	public PaymentServiceException(String message) {
		super(message);
	}
}

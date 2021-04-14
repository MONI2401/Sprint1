package com.cg.cars.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.cars.entities.Payment;
import com.cg.cars.model.PaymentDTO;

public class PaymentUtils {

	public static List<PaymentDTO> convertToPaymentDtoList(List<Payment> list)
	{
		List<PaymentDTO> cardDtoList = new ArrayList<PaymentDTO>();
		for (Payment payment : list)
			cardDtoList.add(convertToPaymentDto(payment));
	    return cardDtoList;
	}
	
	public static Payment convertToPaymnet(PaymentDTO paymentDto) {
		Payment payment = new Payment();
		
		payment.setPaymentId(paymentDto.getPaymentId());
		payment.setType(paymentDto.getType());
		payment.setStatus(paymentDto.getStatus());
		
		return payment;
	}
	
	public static PaymentDTO convertToPaymentDto(Payment payment) {
		PaymentDTO paymentDto = new PaymentDTO();
		
		paymentDto.setPaymentId(payment.getPaymentId());
		paymentDto.setType(payment.getStatus());
		paymentDto.setStatus(payment.getStatus());
		
		return paymentDto;
	}

	
}

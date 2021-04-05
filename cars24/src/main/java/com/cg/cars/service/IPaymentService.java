package com.cg.cars.service;

import java.util.List;

import com.cg.cars.entities.Payment;
import com.cg.cars.model.PaymentDTO;

public interface IPaymentService {
	public PaymentDTO addPayment(Payment payment);

	public PaymentDTO removePayment(long paymentId);

	public PaymentDTO updatePayment(Payment payment);

	public PaymentDTO getPaymentDetails(long paymentId);

	public List<PaymentDTO> getAllPaymentDetails();
}
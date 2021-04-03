package com.cg.cars.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.dao.IPaymentRepository;
import com.cg.cars.entities.Payment;
import com.cg.cars.model.PaymentDTO;
import com.cg.cars.utils.PaymentUtils;

@Service
public class PaymentServiceImp implements IPaymentService{
	
	@Autowired
	IPaymentRepository paymentRepository;

	@Override
	public PaymentDTO addPayment(Payment payment)  {
		
		
			Payment addPayment = paymentRepository.save(payment);
			return PaymentUtils.convertToPaymentDto(addPayment);
			
	}

	@Override
	public PaymentDTO removePayment(int id)  {
		Payment payment = new Payment();
		payment=paymentRepository.getOne(id);
		paymentRepository.deleteById(id);
		return PaymentUtils.convertToPaymentDto(payment);
		}
	

	@Override
	public PaymentDTO updatePayment(Payment payment)  {
		Payment updPayment = paymentRepository.save(payment);
		return PaymentUtils.convertToPaymentDto(updPayment);
	}

	@Override
	public PaymentDTO getPaymentDetails(int id)  {
		Payment getPayment= new Payment();
		getPayment=paymentRepository.findById(id).orElse(null);
		return PaymentUtils.convertToPaymentDto(getPayment);
	}

	@Override
	public List<PaymentDTO> getAllPaymentDetails()  {
		List<Payment> paymentTemp = new ArrayList<Payment> ();
		paymentTemp=paymentRepository.findAll();
		return PaymentUtils.convertToPaymentDtoList(paymentTemp);
		
	}

	public static boolean validatePaymentType(Payment payment) {
		boolean flag = false;
		if (payment.getType()=="Cash" || payment.getType()=="Card") {
			flag = true;
		}
		return flag;
	}

	public static boolean validatePaymentStatus(Payment payment) {
		boolean flag = false;
		if (payment.getStatus()=="Success" || payment.getStatus()== "Failure" || payment.getStatus()== "Pending" ) {
			flag = true;
		}
		return flag;
	}

		

}

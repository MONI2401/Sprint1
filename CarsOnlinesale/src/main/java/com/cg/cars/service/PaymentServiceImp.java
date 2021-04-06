package com.cg.cars.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cars.dao.IPaymentRepository;
import com.cg.cars.entities.Payment;
import com.cg.cars.exception.PaymentServiceException;
import com.cg.cars.model.PaymentDTO;
import com.cg.cars.utils.PaymentUtils;


@Service
public class PaymentServiceImp implements IPaymentService {

	@Autowired
	IPaymentRepository paymentRepository;

	@Override
	public PaymentDTO addPayment(Payment payment) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(payment.getPaymentId());
		if (paymentTemp.isEmpty() )
		{
			if( validatePaymentType(payment)  && validatePaymentStatus(payment)  
				&& validateCardName(payment) && validateCvv(payment)  
			&& validateCardNumber(payment) && validateCardExpiry(payment) )
			{
				Payment addPayment = paymentRepository.save(payment);
				return PaymentUtils.convertToPaymentDto(addPayment);
			}
			else
			{
				throw new PaymentServiceException("Enter the valid payment detials");
			}
		
		} 
		else 
		{
			throw new PaymentServiceException("Payment already exists ");
		}
	}

	@Override
	public PaymentDTO removePayment(long paymentId) throws PaymentServiceException {
		Optional<Payment> payment = paymentRepository.findById(paymentId);
		if (payment.isEmpty()) 
		{
			throw new PaymentServiceException("Payment does not exist for paymenId to delete");
		} 
		else 
		{
			paymentRepository.deleteById(paymentId);
			if(payment.isPresent())
			{
				return PaymentUtils.convertToPaymentDto(payment.get());
			}
			else
			{
				throw new PaymentServiceException("Payment is not present ");
			}
		}
	}

	@Override
	public PaymentDTO updatePayment(long paymentId, Payment payment) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(paymentId);
		if ( !paymentTemp.isEmpty() )
		{
			if(	validatePaymentStatus(payment) && validatePaymentType(payment)
				&&  validateCardName(payment) && validateCardNumber(payment) 
				&& validateCvv(payment) && validateCardExpiry(payment) )
			{
				Payment updatePayment = paymentRepository.save(payment);
				return PaymentUtils.convertToPaymentDto(updatePayment);
			}
			else
			{
				throw new PaymentServiceException("Enter the valid payment detials");
			}
		}
		else 
		{
			throw new PaymentServiceException("Payment does not exist for PaymentId");
		}
	}

	@Override
	public PaymentDTO getPaymentDetails(long paymentId) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(paymentId);
		if (paymentTemp.isEmpty()) {
			throw new PaymentServiceException("Payment does not exist fro paymentId");
		} 
		else 
		{
			Payment getPayment = paymentRepository.findById(paymentId).orElse(null);
			return PaymentUtils.convertToPaymentDto(getPayment);
		}
	}

	@Override
	public List<PaymentDTO> getAllPaymentDetails() throws PaymentServiceException {
		List<Payment> paymentTemp = paymentRepository.findAll();
		if (paymentTemp.isEmpty()) {
			throw new PaymentServiceException("Payments not found");
		} 
		else 
		{
			List<Payment> getAllPayment = paymentRepository.findAll();
			return PaymentUtils.convertToPaymentDtoList(getAllPayment);
		}
	}

	public static  boolean validatePaymentType(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[A-Za-z]*$"); 
		CharSequence cs= payment.getType();
		if (pattern.matcher(cs).matches() && !payment.getType().isBlank()) {
			flag = true;
		} 
		else 
		{
			flag = false;
		}
		return flag;
	}

	public  static boolean validatePaymentStatus(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[A-Za-z]*$");
		CharSequence cs= payment.getStatus();
		if (pattern.matcher(cs).matches() && !payment.getStatus().isBlank()) {
			flag = true;
		} 
		else
		{
			flag = false;
		}
		return flag;
	}

	public static boolean validateCardName(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z ]*$");
		CharSequence cs= payment.getCards().getCardName();
		if (pattern.matcher(cs).matches() && !payment.getCards().getCardName().isBlank()) {
			flag = true;
		} 
		else 
		{
			flag = false;
		}
		return flag;
	}

	public static boolean validateCardNumber(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[0-9]*$");
		CharSequence cs= payment.getCards().getCardNumber();
		if ((pattern.matcher(cs).matches()) && payment.getCards().getCardNumber().length() == 16 ) 
		{
			flag = true;
		} 
		else 
		{
			flag = false;
		}
		return flag;
	}

	public static boolean validateCvv(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[0-9]{3}$");
		String stringCvv = String.valueOf(payment.getCards().getCvv());
		CharSequence cs= stringCvv ;
		if ((pattern.matcher(cs).matches())) {
			flag = true;
		} 
		else 
		{
			flag = false;
		}
		return flag;

	}

	public static boolean validateCardExpiry(Payment payment) {
		boolean flag = false;
		if (payment.getCards().getCardExpiry() != null && payment.getCards().getCardExpiry().isAfter(LocalDate.now())) {
			flag = true;
		} 
		else 
		{
			flag = false;
		}
		return flag;
	}

}
package com.cg.cars.service;

<<<<<<< HEAD
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.dao.IPaymentRepository;
import com.cg.cars.entities.Payment;
import com.cg.cars.exception.PaymentServiceException;
import com.cg.cars.model.PaymentDTO;
import com.cg.cars.utils.PaymentUtils;

/**
*Author     : Avinash
*Date       :08-04-2021
*Description:This is  Payment Service Class that 
*			 provide services to add a payment, remove payment, update payment 
*            and to view payment details
**/

@Service
public class PaymentServiceImp implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;
	
	/**
	 * Description  :To add Payment to the database 
	 * Input Params :Payment object to be added to the database 
	 * Return Value :PaymentDTO object 
	 * Exception    : PaymentServiceException - It is raised when payment already exist
	 **/

	@Transactional
	@Override
	public PaymentDTO addPayment(Payment payment) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(payment.getPaymentId());
		if (paymentTemp.isEmpty()) {
			if (validatePaymentType(payment) && validatePaymentStatus(payment) && validateCardName(payment)
					&& validateCvv(payment) && validateCardNumber(payment) && validateCardExpiry(payment)) {
				Payment addPayment = paymentRepository.save(payment);
				return PaymentUtils.convertToPaymentDto(addPayment);
			} else {
				throw new PaymentServiceException("Enter the valid payment detials");
			}

		} else {
			throw new PaymentServiceException("Payment already exists ");
		}
	}

	/**
	 * Description :To delete Payment from the database 
	 * Input Params :Payment id to be deleted from the database 
	 * Return Value :PaymentDTO object of the payment been deleted 
	 * Exception :PaymentServiceException-It is raised when payment ID doesn't exist
	 **/
	
	@Transactional
	@Override
	public PaymentDTO removePayment(long paymentId) throws PaymentServiceException {
		Optional<Payment> payment = paymentRepository.findById(paymentId);
		if (payment.isEmpty()) {
			throw new PaymentServiceException("Payment does not exist for paymenId to delete");
		} else {
			paymentRepository.deleteById(paymentId);
			if (payment.isPresent()) {
				return PaymentUtils.convertToPaymentDto(payment.get());
			} else {
				throw new PaymentServiceException("Payment is not present ");
			}
		}
	}

	/**
	 * 
	 * Description :To update Payment details to the database 
	 * Input Params :Payment to be updated in the database 
	 * Return Value :PaymentDTO object of the payment been updated 
	 * Exception :PaymentServiceException-It is raised when payment doesn't exist
	 **/
	
	@Transactional
	@Override
	public PaymentDTO updatePayment(long paymentId, Payment payment) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(paymentId);
		if (!paymentTemp.isEmpty()) {
			if (validatePaymentStatus(payment) && validatePaymentType(payment) && validateCardName(payment)
					&& validateCardNumber(payment) && validateCvv(payment) && validateCardExpiry(payment)) {
				Payment updatePayment = paymentRepository.save(payment);
				return PaymentUtils.convertToPaymentDto(updatePayment);
			} else {
				throw new PaymentServiceException("Enter the valid payment detials");
			}
		} else {
			throw new PaymentServiceException("Payment does not exist for PaymentId");
		}
	}

	/**
	 * Description :To fetch Payment details from the database 
	 * Input Params :Payment ID object to be fetched from the database 
	 * Return Value :PaymentDTO object of the payment been fetched 
	 * Exception :PaymentServiceException-It is raised when payment Id doesn't exist
	 **/
	
	@Transactional
	@Override
	public PaymentDTO getPaymentDetails(long paymentId) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(paymentId);
		if (paymentTemp.isEmpty()) {
			throw new PaymentServiceException("Payment does not exist fro paymentId");
		} else {
			Payment getPayment = paymentRepository.findById(paymentId).orElse(null);
			return PaymentUtils.convertToPaymentDto(getPayment);
		}
	}
	
	/**
	 * Description :To fetch payment details from the database 
	 * Return Value:List<PaymentDTO> object of the payment been fetched 
	 * Exception : PaymentServiceException-It is raised when payment not found
	 **/

	@Transactional
	@Override
	public List<PaymentDTO> getAllPaymentDetails() throws PaymentServiceException {
		List<Payment> paymentTemp = paymentRepository.findAll();
		if (paymentTemp.isEmpty()) {
			throw new PaymentServiceException("Payments not found");
		} else {
			List<Payment> getAllPayment = paymentRepository.findAll();
			return PaymentUtils.convertToPaymentDtoList(getAllPayment);
		}
	}

	public boolean validatePaymentType(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[A-Za-z]*$");
		CharSequence cs = payment.getType();
		if (pattern.matcher(cs).matches() && !payment.getType().isBlank()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean validatePaymentStatus(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[A-Za-z]*$");
		CharSequence cs = payment.getStatus();
		if (pattern.matcher(cs).matches() && !payment.getStatus().isBlank()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean validateCardName(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z ]*$");
		CharSequence cs = payment.getCard().getCardName();
		if (pattern.matcher(cs).matches() && !payment.getCard().getCardName().isBlank()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean validateCardNumber(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[0-9]*$");
		CharSequence cs = payment.getCard().getCardNumber();
		if ((pattern.matcher(cs).matches()) && payment.getCard().getCardNumber().length() == 16) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean validateCvv(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[0-9]{3}$");
		String stringCvv = String.valueOf(payment.getCard().getCvv());
		CharSequence cs = stringCvv;
		if ((pattern.matcher(cs).matches())) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}

	public boolean validateCardExpiry(Payment payment) {
		boolean flag = false;
		if (payment.getCard().getCardExpiry() != null && payment.getCard().getCardExpiry().isAfter(LocalDate.now())) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

}
=======
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
>>>>>>> refs/remotes/origin/master

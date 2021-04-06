package com.cg.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.entities.Payment;
import com.cg.cars.exception.PaymentServiceException;
import com.cg.cars.model.PaymentDTO;
import com.cg.cars.service.IPaymentService;
import com.cg.cars.service.PaymentServiceImp;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
		@Autowired
		IPaymentService paymentService;
		
		@PostMapping(path="/addPayment",consumes ="application/json")
		public ResponseEntity<PaymentDTO> addPayment(@RequestBody Payment payment) {
			if (PaymentServiceImp.validatePaymentType(payment) && PaymentServiceImp.validatePaymentStatus(payment)) {
			PaymentDTO resultpayment = paymentService.addPayment(payment);
			return new ResponseEntity<PaymentDTO>(resultpayment, HttpStatus.OK);
			}
			else
				return new ResponseEntity<PaymentDTO>(new PaymentDTO(), HttpStatus.EXPECTATION_FAILED);
		}
		
		@DeleteMapping(path="/deletePayment/{paymentId}",produces="application/json")
		public PaymentDTO removePayment(@PathVariable long paymentId) throws PaymentServiceException {
			if(paymentId!=0) {
			return paymentService.removePayment(paymentId);
			}
			throw new PaymentServiceException("ID cannot be empty");
		}
		
		@PutMapping("/updatePayment")
		@ExceptionHandler(value = Exception.class)
		public ResponseEntity<PaymentDTO> updatePayment(@RequestBody Payment payment) {
			if (PaymentServiceImp.validatePaymentType(payment) && PaymentServiceImp.validatePaymentStatus(payment)) {
			PaymentDTO resultPayment = paymentService.updatePayment(payment);
			return new ResponseEntity<PaymentDTO>(resultPayment, HttpStatus.OK);
			}
			throw new PaymentServiceException("Enter Valid Payment Details");
		}
		
		@GetMapping(path="/getPaymentDetails/{paymentId}",produces = "application/json")
		@ExceptionHandler(value = PaymentServiceException.class)
		public ResponseEntity<PaymentDTO> GetPaymentDetails(@PathVariable long paymentId)  {
			if(paymentId!=0) {
			PaymentDTO resultPayment = paymentService.getPaymentDetails(paymentId);
			return new ResponseEntity<PaymentDTO>(resultPayment, HttpStatus.OK);
			}
			throw new PaymentServiceException("ID cannot be empty");
		}
		
		@GetMapping(path="/getAllPaymentDetails",produces = "application/json")
		public ResponseEntity<List<PaymentDTO>> getAllPayment() {
			List<PaymentDTO> resultPayment = paymentService.getAllPaymentDetails();
			return new ResponseEntity<List<PaymentDTO>>(resultPayment, HttpStatus.OK);
		}
		
}

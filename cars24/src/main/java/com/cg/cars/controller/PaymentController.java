package com.cg.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
		@Autowired
		IPaymentService paymentService;
		
		@PostMapping(path="/addPayment",consumes ="application/json")
		public ResponseEntity<PaymentDTO> addPayment(@RequestBody Payment payment) {
			PaymentDTO resultpayment = paymentService.addPayment(payment);
			return new ResponseEntity<PaymentDTO>(resultpayment, HttpStatus.OK);
		}
		
		@DeleteMapping(path="/deletePayment/{paymentId}",produces="application/json")
		public PaymentDTO removePayment(@PathVariable long paymentId)  {
			return paymentService.removePayment(paymentId);
		}
		
		@PutMapping("/updatePayment")
		public ResponseEntity<PaymentDTO> updatePayment(@RequestBody Payment payment) {
			PaymentDTO resultPayment = paymentService.updatePayment(payment);
			return new ResponseEntity<PaymentDTO>(resultPayment, HttpStatus.OK);
		}
		
		@GetMapping(path="/getPaymentDetails/{paymentId}",produces = "application/json")
		public ResponseEntity<PaymentDTO> GetPaymentDetails(@PathVariable long paymentId)  {
			PaymentDTO resultPayment = paymentService.getPaymentDetails(paymentId);
			return new ResponseEntity<PaymentDTO>(resultPayment, HttpStatus.OK);
		}
		
		@GetMapping(path="/getAllPaymentDetails",produces = "application/json")
		public ResponseEntity<List<PaymentDTO>> getAllPayment() {
			List<PaymentDTO> resultPayment = paymentService.getAllPaymentDetails();
			return new ResponseEntity<List<PaymentDTO>>(resultPayment, HttpStatus.OK);
		}
		
}

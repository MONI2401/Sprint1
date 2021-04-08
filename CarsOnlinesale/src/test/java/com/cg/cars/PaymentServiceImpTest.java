package com.cg.cars;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cars.entities.Card;
import com.cg.cars.entities.Payment;
import com.cg.cars.model.PaymentDTO;
import com.cg.cars.service.IPaymentService;
import com.cg.cars.utils.PaymentUtils;
@SpringBootTest
class PaymentServiceImpTest {
	@Autowired
	IPaymentService service;

	@Disabled
	@Test
	void testAddPayment() {
		Payment pay=new Payment();
		pay.setPaymentId(38);
		pay.setType("Card");
		pay.setStatus("Success");
		pay.setCard(new Card(2,"Avinash", "1234567898765412", LocalDate.parse("2030-02-28"), 919));
		Payment addPay=PaymentUtils.convertToPayment(service.addPayment(pay));
		pay.setPaymentId(addPay.getPaymentId());
		pay.setCard(addPay.getCard());
		assertEquals(pay,addPay);
	}

	@Test
	void testRemovePayment() {
		Payment pay=new Payment();
		pay.setPaymentId(60);
		pay.setType("Card");
		pay.setStatus("Success");
		pay.setCard(new Card(59,"Avinash","1234567898765412", LocalDate.parse("2030-02-28"), 919));
		Payment addPay=PaymentUtils.convertToPayment(service.removePayment(60));
		pay.setPaymentId(addPay.getPaymentId());
		pay.setCard(addPay.getCard());
		assertEquals(pay,addPay);
	}

	@Disabled
	@Test
	void testUpdatePayment() {
		Payment pay=new Payment();
		pay.setPaymentId(1);
		pay.setType("Card");
		pay.setStatus("Success");
		pay.setCard(new Card(1001,"Visa", "1478529631472511", LocalDate.parse("2022-01-24"), 121));
		Payment updPay=PaymentUtils.convertToPayment(service.updatePayment(1, pay));
		pay.setPaymentId(updPay.getPaymentId());
		pay.setCard(updPay.getCard());
		assertEquals(pay,updPay);
	}

	@Test
	void testGetPaymentDetails() {
		PaymentDTO getPaymentID=service.getPaymentDetails(1);
		assertEquals("Card", getPaymentID.getType());
	}

	@Test
	void testGetAllPaymentDetails() {
		List<Payment> list= new ArrayList<Payment>();
		Payment pay=new Payment();
		pay.setPaymentId(1);
		pay.setType("Card");
		pay.setStatus("Success");
		pay.setCard(new Card(1001,"Visa", "1478529631472511", LocalDate.parse("2022-01-24"), 121));
		list.add(pay);
		List<PaymentDTO> DTOlist=PaymentUtils.convertToPaymentDtoList(list);
		List<PaymentDTO> result= service.getAllPaymentDetails();
		DTOlist.sort(null);
		result.sort(null);
		assertEquals(DTOlist, result);
	}

	
	
}

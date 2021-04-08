package com.cg.cars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cars.entities.Customer;
import com.cg.cars.entities.Order;
import com.cg.cars.entities.Payment;
import com.cg.cars.model.OrderDTO;
import com.cg.cars.service.IOrderService;
import com.cg.cars.utils.OrderUtils;

@SpringBootTest
class OrderServiceImpTest {
	@Autowired
	IOrderService service;

	@Disabled
	@Test
	void testAddOrder() {
		Order ord = new Order();
		ord.setOrderId(23);
		ord.setAmount(20000);
		ord.setBillingDate(LocalDate.parse("2000-07-03"));
		ord.setCustomer(new Customer(1, "Avinash", "avinash@gmail.com", "9840712511",
				LocalDate.parse("2000-12-01"), "A2", "12 th", "Anna Nagar", "Chennai", "Tamil Nadu", 600012));
		ord.setPaymentMethod(new Payment(3, "Card", "Success", 2, "Avinash", "1234567898765412",
				LocalDate.parse("2030-02-28"), 919));
		Order addOrd = OrderUtils.convertToOrder(service.addOrder(ord));
		ord.setOrderId(addOrd.getOrderId());
		ord.setCustomer(addOrd.getCustomer());
		ord.setPaymentMethod(addOrd.getPaymentMethod());
		assertEquals(ord, addOrd);
	}

	@Disabled
	@Test
	void testRemoveOrder() {
		Order ord = new Order();
		ord.setOrderId(67);
		ord.setAmount(25000);
		ord.setBillingDate(LocalDate.parse("2000-07-03"));
		ord.setCustomer(new Customer(19, "dhivya", "dhivyas@gmail.com", "4740712511", LocalDate.parse("2000-12-01"),
				"A2", "12 th", "Anna Nagar", "Chennai", "Tamil Nadu", 600012));
		ord.setPaymentMethod(new Payment(1, "Cash", "Success", 101, "Debit Card", "147852963147251",
				LocalDate.parse("2025-01-20"), 121));	
		Order remOrd=OrderUtils.convertToOrder(service.removeOrder(67));
		assertEquals(ord, remOrd);
	}

	@Disabled
	@Test
	void testUpdateOrder() {
		Order ord = new Order();
		ord.setOrderId(67);
		ord.setAmount(25000);
		ord.setBillingDate(LocalDate.parse("2000-07-03"));
		ord.setCustomer(new Customer(19, "dhivya", "dhivyas@gmail.com", "4740712511", LocalDate.parse("2000-12-01"),
				"A2", "12 th", "Anna Nagar", "Chennai", "Tamil Nadu", 600012));
		ord.setPaymentMethod(new Payment(1, "Cash", "Success", 101, "Debit Card", "147852963147251",
				LocalDate.parse("2025-01-20"), 121));
		Order updateOrd = OrderUtils.convertToOrder(service.updateOrder(67, ord));
		ord.setOrderId(updateOrd.getOrderId());
		ord.setCustomer(updateOrd.getCustomer());
		ord.setPaymentMethod(updateOrd.getPaymentMethod());
		assertEquals(ord, updateOrd);
	}

	@Disabled
	@Test
	void testGetOrderDetails() {
		OrderDTO getOrderID = service.getOrderDetails(67);
		assertEquals("25000.0", getOrderID.getAmount().toString());
	}

	@Disabled
	@Test
	void testGetAllOrders() {
		List<Order> list= new ArrayList<Order>();
		Order ord = new Order();
		ord.setOrderId(67);
		ord.setAmount(25000);
		ord.setBillingDate(LocalDate.parse("2000-07-03"));
		ord.setCustomer(new Customer(19, "dhivya", "dhivyas@gmail.com", "4740712511", LocalDate.parse("2000-12-01"),
				"A2", "12 th", "Anna Nagar", "Chennai", "Tamil Nadu", 600012));
		ord.setPaymentMethod(new Payment(1, "Card", "Failure", 1001, "Visa", "1478529631472511",
				LocalDate.parse("2022-01-24"), 121));
		list.add(ord);
		List<OrderDTO> DTOlist=OrderUtils.convertToOrderDtoList(list);
		List<OrderDTO> result= service.getAllOrders();
		assertEquals(DTOlist, result);
	}

}

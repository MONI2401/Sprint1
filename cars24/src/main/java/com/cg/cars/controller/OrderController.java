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

import com.cg.cars.entities.Order;
import com.cg.cars.exception.OrderServiceException;
import com.cg.cars.model.OrderDTO;
import com.cg.cars.service.IOrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
		@Autowired
		IOrderService orderService;
		
		@PostMapping("/addOrder")
		public ResponseEntity<OrderDTO> addOrder(@RequestBody Order order) {
			OrderDTO resultorder = orderService.addOrder(order);
			return new ResponseEntity<OrderDTO>(resultorder, HttpStatus.OK);
		}
		
		@DeleteMapping("/removeOrder/{orderId}")
		public OrderDTO removeOrder(@PathVariable long orderId)  {
			return orderService.removeOrder(orderId);
		}
		
		@PutMapping("/updateOrder")
		public ResponseEntity<OrderDTO> updateOrder(@RequestBody long id, Order order) {
			OrderDTO resultOrder = orderService.updateOrder(id, order);
			return new ResponseEntity<OrderDTO>(resultOrder, HttpStatus.OK);
		}
		
		@GetMapping("/getOrderDetails/{orderId}")
		public ResponseEntity<OrderDTO> GetOrderDetails(@PathVariable long orderId)  {
			OrderDTO resultOrder = orderService.getOrderDetails(orderId);
			return new ResponseEntity<OrderDTO>(resultOrder, HttpStatus.OK);
		}
		
		@GetMapping("/getAllOrders")
		public ResponseEntity<List<OrderDTO>> getAllOrders() {
			List<OrderDTO> resultOrder = orderService.getAllOrders();
			return new ResponseEntity<List<OrderDTO>>(resultOrder, HttpStatus.OK);
		}
		
}
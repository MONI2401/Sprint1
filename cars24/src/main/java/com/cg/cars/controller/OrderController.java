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
import com.cg.cars.model.OrderDTO;
import com.cg.cars.service.IOrderService;

/**
*Author: Dhivya
*Date:08-04-2021
*Description:This is Order Controller Layer
**/

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	/**
	*Description	:To add Order to the database
	*Input Params	:Order object to be added to the database
	*Return Value	:OrderDTO object
	*Exception	    :OrderServiceException-It is raised when order already exist   
	**/
	
	@PostMapping("/addOrder")
	public ResponseEntity<OrderDTO> addOrder(@RequestBody Order order) {
		OrderDTO resultorder = orderService.addOrder(order);
		return new ResponseEntity<OrderDTO>(resultorder, HttpStatus.OK);
	}

	/**
	*Description	:To delete Order from the database
	*Input Params	:Order id to be deleted from the database
	*Return Value	:OrderDTO object of the Order been deleted
	*Exception	    :OrderServiceException-It is raised when order ID doesn't exist   
	**/
	
	@DeleteMapping("/removeOrder/{orderId}")
	public OrderDTO removeOrder(@PathVariable long orderId) {
		return orderService.removeOrder(orderId);
	}

	/**

	*Description	:To update Order details to the database
	*Input Params	:Order to be updated in the database
	*Return Value	:OrderDTO object of the Order been updated
	*Exception	    :OrderServiceException-It is raised when order doesn't exist   
	**/
	
	@PutMapping("/updateOrder/{id}")
	public ResponseEntity<OrderDTO> updateOrder(@RequestBody  Order order) {
		OrderDTO resultOrder = orderService.updateOrder(order.getOrderId(), order);
		return new ResponseEntity<OrderDTO>(resultOrder, HttpStatus.OK);
	}

	/**
	*Description	:To fetch Order details from the database
	*Input Params	:Order ID object to be fetched from the database
	*Return Value	:OrderDTO object of the Order been fetched
	*Exception	    :OrderServiceException-It is raised when order id doesn't exist   
	**/
	
	@GetMapping("/getOrderDetails/{orderId}")
	public ResponseEntity<OrderDTO> GetOrderDetails(@PathVariable long orderId) {
		OrderDTO resultOrder = orderService.getOrderDetails(orderId);
		return new ResponseEntity<OrderDTO>(resultOrder, HttpStatus.OK);
	}
	
	/**
	*Description	:To fetch Order details from the database
	*Return Value	:List<OrderDTO> object of the Order been fetched
	*Exception	:OrderServiceException-It is raised when order not found  
	**/

	@GetMapping("/getAllOrders")
	public ResponseEntity<List<OrderDTO>> getAllOrders() {
		List<OrderDTO> resultOrder = orderService.getAllOrders();
		return new ResponseEntity<List<OrderDTO>>(resultOrder, HttpStatus.OK);
	}

}
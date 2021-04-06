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

import com.cg.cars.entities.Order;
import com.cg.cars.exception.OrderServiceException;
import com.cg.cars.model.OrderDTO;
import com.cg.cars.service.IOrderService;
import com.cg.cars.service.OrderServiceImp;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
		@Autowired
		IOrderService orderService;
		
		@PostMapping(path="/addOrder",consumes ="application/json")
		public ResponseEntity<OrderDTO> addOrder(@RequestBody Order order)
		{
            if (OrderServiceImp.validatePaymentMethod(order) )
            {          
		      OrderDTO resultorder = orderService.addOrder(order);
		      return new ResponseEntity<OrderDTO>(resultorder, HttpStatus.OK);
		    }
		   else
             return new ResponseEntity<OrderDTO>(new OrderDTO(),                                                               HttpStatus.EXPECTATION_FAILED);
		}

		@DeleteMapping(path="/deleteOrder/{orderId}",produces="application/json")
		public OrderDTO removeOrder(@PathVariable long orderId) throws OrderServiceException
		{
           if(orderId!=0)
              {
			  return orderService.removeOrder(orderId);
		      }
         throw new OrderServiceException("ID cannot be empty");
          }

		
		@PutMapping("/updateOrder")
        @ExceptionHandler(value = Exception.class)
		public ResponseEntity<OrderDTO> updateOrder(@RequestBody Order order) 
		{
            if (OrderServiceImp.validatePaymentMethod(order) ) 
            {
			  OrderDTO resultOrder = orderService.updateOrder(0, order );
			  return new ResponseEntity<OrderDTO>(resultOrder, HttpStatus.OK);
		    }
        throw new OrderServiceException("Enter Valid Order Details");
		}

		@GetMapping(path="/getOrderDetails/{orderId}",produces = "application/json")
        @ExceptionHandler(value = OrderServiceException.class)
		public ResponseEntity<OrderDTO> GetOrderDetails(@PathVariable long orderId)
		{
            if(orderId!=0) 
             {
			  OrderDTO resultOrder = orderService.getOrderDetails(orderId);
			  return new ResponseEntity<OrderDTO>(resultOrder, HttpStatus.OK);
		     }
        throw new OrderServiceException("ID cannot be empty");
		}

		@GetMapping(path="/getAllOrders",produces = "application/json")
		public ResponseEntity<List<OrderDTO>> getAllOrders()
		{
			List<OrderDTO> resultOrder = orderService.getAllOrders();
			return new ResponseEntity<List<OrderDTO>>(resultOrder, HttpStatus.OK);
		}
		
}
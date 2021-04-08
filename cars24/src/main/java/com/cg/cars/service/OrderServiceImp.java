package com.cg.cars.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.dao.IOrderRepository;
import com.cg.cars.entities.Order;
import com.cg.cars.model.OrderDTO;
import com.cg.cars.utils.OrderUtils;

/**
*Author     : Dhivya
*Date       :08-04-2021
*Description:This is  Order Service Class that 
*			 provide services to add a order, remove order, update an order 
*            and to view order details
**/

@Service
public class OrderServiceImp implements IOrderService {

	@Autowired
	private IOrderRepository orderRepo;

	/**
	*Description	:To add Order to the database
	*Input Params	:Order object to be added to the database
	*Return Value	:OrderDTO object
	*Exception	    :OrderServiceException-It is raised when order already exist   
	**/
	
	@Transactional
	@Override
	public OrderDTO addOrder(Order order) {
		Order addOrder = new Order();
		addOrder = orderRepo.save(order);
		return OrderUtils.convertToOrderDto(addOrder);
	}
	
	/**
	*Description	:To delete Order from the database
	*Input Params	:Order id to be deleted from the database
	*Return Value	:OrderDTO object of the Order been deleted
	*Exception	    :OrderServiceException-It is raised when order ID doesn't exist   
	**/

	@Transactional
	@Override
	public OrderDTO removeOrder(long id) {

		Order ordertemp = new Order();
		ordertemp = orderRepo.getOne(id);
		orderRepo.deleteById(id);
		return OrderUtils.convertToOrderDto(ordertemp);
	}
	
	/**

	*Description	:To update Order details to the database
	*Input Params	:Order to be updated in the database
	*Return Value	:OrderDTO object of the Order been updated
	*Exception	    :OrderServiceException-It is raised when order doesn't exist   
	**/

	@Transactional
	@Override
	public OrderDTO updateOrder(long id, Order order) {
		Order updateOrder = orderRepo.save(order);
		return OrderUtils.convertToOrderDto(updateOrder);
	}
	
	/**
	*Description	:To fetch Order details from the database
	*Input Params	:Order ID object to be fetched from the database
	*Return Value	:OrderDTO object of the Order been fetched
	*Exception	    :OrderServiceException-It is raised when order id doesn't exist   
	**/

	@Transactional
	@Override
	public OrderDTO getOrderDetails(long id) {
		Order getOrderDetails = new Order();
		getOrderDetails = orderRepo.findById(id).orElse(null);
		return OrderUtils.convertToOrderDto(getOrderDetails);
	}

	public static boolean validatePaymentMethod(Order order) {
		boolean flag = false;
		if (order.getPaymentMethod().getType() == "Cash" || order.getPaymentMethod().getType() == "Card") {
			flag = true;
		}
		return flag;
	}
	
	/**
	*Description	:To fetch Order details from the database
	*Return Value	:List<OrderDTO> object of the Order been fetched
	*Exception	:OrderServiceException-It is raised when order not found  
	**/

	@Transactional
	@Override
	public List<OrderDTO> getAllOrders() {
		List<Order> getorder = new ArrayList<Order>();
		getorder = orderRepo.findAll();
		return OrderUtils.convertToOrderDtoList(getorder);
	}

}
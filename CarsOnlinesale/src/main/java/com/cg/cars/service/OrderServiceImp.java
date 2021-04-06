package com.cg.cars.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.dao.IOrderRepository;
import com.cg.cars.entities.Order;
import com.cg.cars.model.OrderDTO;
import com.cg.cars.utils.OrderUtils;

@Service
public class OrderServiceImp implements IOrderService {

	@Autowired
	IOrderRepository orderRepo;

	@Override
	public OrderDTO addOrder(Order order) {
		Order addOrder = new Order();
		addOrder = orderRepo.save(order);
		return OrderUtils.convertToOrderDto(addOrder);
	}

	@Override
	public OrderDTO removeOrder(long id) {

		Order ordertemp = new Order();
		ordertemp = orderRepo.getOne((int) id);
		orderRepo.deleteById((int) id);
		return OrderUtils.convertToOrderDto(ordertemp);
	}

	@Override
	public OrderDTO updateOrder(long id, Order order) {
		Order updateOrder = new Order();
		updateOrder = orderRepo.save(order);
		return OrderUtils.convertToOrderDto(updateOrder);
	}

	@Override
	public OrderDTO getOrderDetails(long id) {
		Order getOrderDetails = new Order();
		getOrderDetails = orderRepo.findById((int) id).orElse(null);
		return OrderUtils.convertToOrderDto(getOrderDetails);
	}

	public static boolean validatePaymentMethod(Order order) {
		boolean flag = false;
		if (order.getPaymentMethod() == "Cash" || order.getPaymentMethod() == "Card") {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		List<Order> getorder = new ArrayList<Order>();
		getorder = orderRepo.findAll();
		return OrderUtils.convertToOrderDtoList(getorder);
	}

}
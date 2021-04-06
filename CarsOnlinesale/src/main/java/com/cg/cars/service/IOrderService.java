package com.cg.cars.service;

import java.util.List;
import com.cg.cars.entities.Order;
import com.cg.cars.model.OrderDTO;

public interface IOrderService {

	public OrderDTO addOrder(Order order);

	public OrderDTO removeOrder(long id);

	public OrderDTO updateOrder(long id, Order order);

	public OrderDTO getOrderDetails(long id);

	public List<OrderDTO> getAllOrders();

}
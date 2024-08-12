package com.wu.ecommerce.service;

import java.util.ArrayList;

import com.wu.ecommerce.dto.Order;
import com.wu.ecommerce.repo.OrderRepository;
import com.wu.ecommerce.repo.OrderRepositoryImpl;

public class OrderServiceImpl implements OrderService {
	
	private OrderRepository orderRepository = OrderRepositoryImpl.getInstance();
	
	private OrderServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static OrderService orderService;
	
	public static OrderService getInstance()
	{
		if(orderService == null)
		{
			orderService = new OrderServiceImpl();
		}
		return orderService;
	}

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.addOrder(order);
	}

	@Override
	public Order getOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Order> getOrderByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateOrderDetails(String id, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}

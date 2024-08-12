package com.wu.ecommerce.repo;

import java.util.ArrayList;

import com.wu.ecommerce.dto.Order;

public class OrderRepositoryImpl implements OrderRepository {

	private OrderRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	private static OrderRepository orderRepository;

	public static OrderRepository getInstance() {
		if (orderRepository == null) {
			orderRepository = new OrderRepositoryImpl();
		}

		return orderRepository;
	}

	private ArrayList<Order> orders = new ArrayList<Order>();

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		boolean result = orders.add(order);
		System.out.println(result);
		return order;
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

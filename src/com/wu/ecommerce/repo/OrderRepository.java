package com.wu.ecommerce.repo;

import java.util.ArrayList;

import com.wu.ecommerce.dto.Order;

public interface OrderRepository {
	
	public Order addOrder(Order order);
	
	public Order getOrderByOrderId(String orderId);
	
	public ArrayList<Order> getOrderByUserId(String userId);
	
	public Order updateOrderDetails(String id, Order order);
	
	public String deleteOrder(String id);

}

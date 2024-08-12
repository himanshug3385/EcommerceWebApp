package com.wu.ecommerce.repo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wu.ecommerce.dto.Order;
import com.wu.ecommerce.dto.Users;

public interface UsersRepository {

	public Users addUser(Users order) throws SQLException;
	
	public Users getUserByUserId(String userId);
	
//	public ArrayList<Order> getOrderByUserId(String userId);
	
//	public Order updateOrderDetails(String id, Order order);
	
//	public String deleteOrder(String id);
}

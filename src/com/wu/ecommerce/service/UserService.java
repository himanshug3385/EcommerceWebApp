package com.wu.ecommerce.service;

import java.sql.SQLException;

import com.wu.ecommerce.dto.Users;

public interface UserService {

	public Users addUser(Users order) throws SQLException;
	
	public Users getUserByUserId(String userId);
}

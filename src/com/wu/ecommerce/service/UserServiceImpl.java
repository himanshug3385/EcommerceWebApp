package com.wu.ecommerce.service;

import java.sql.SQLException;

import com.wu.ecommerce.dto.Users;
import com.wu.ecommerce.repo.ProductRepository;
import com.wu.ecommerce.repo.ProductRepositoryImpl;
import com.wu.ecommerce.repo.UserRepositoryImpl;
import com.wu.ecommerce.repo.UsersRepository;

public class UserServiceImpl implements UserService {
	
	private static UserService userService;
	
	private UsersRepository usersRepository = UserRepositoryImpl.getInstance();
	
	public static UserService getInstance()
	{
		if(userService == null)
		{
			userService = new UserServiceImpl();
		}
		return userService;
	}

	@Override
	public Users addUser(Users user) throws SQLException {
		// TODO Auto-generated method stub
		return usersRepository.addUser(user) ;
	}

	@Override
	public Users getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

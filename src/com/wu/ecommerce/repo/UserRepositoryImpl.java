package com.wu.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wu.ecommerce.dto.Users;
import com.wu.ecommerce.utils.DbUtils;

public class UserRepositoryImpl implements UsersRepository {

	private static UsersRepository usersRepository;

	public static UsersRepository getInstance() {
		if (usersRepository == null) {
			usersRepository = new UserRepositoryImpl();
		}

		return usersRepository;
	}
	
	@Override
	public Users addUser(Users users) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DbUtils.getInstance().getConnection();
		
	String str = "insert into user_table (USERID, FIRSTNAME, LASTNAME, ORDERID) values (?, ? , ? , ? )";
	
		PreparedStatement preparedStatement = connection.prepareStatement(str);
		preparedStatement.setInt(1, users.getUserID());
		preparedStatement.setString(2, users.getFirstName());
		preparedStatement.setString(3,  users.getLastName());
		preparedStatement.setInt(4, users.getOrderID());
		
	 int rowUpdated = preparedStatement.executeUpdate();
	 
	 if(rowUpdated > 0)
	 {
		 System.out.println("Ussr Inserted Successfully");
	 }
	 else
	 {
		 System.out.println("Failure");
	 }
		
//		execute , executeUpdate, executeQuery;
//		products.add(product);
//		System.out.println(result);
//		return product;
		return users;
	}

	@Override
	public Users getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

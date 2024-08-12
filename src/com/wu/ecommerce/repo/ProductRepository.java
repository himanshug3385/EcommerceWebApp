package com.wu.ecommerce.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exceptions.DataNotFoundException;
import com.wu.ecommerce.exceptions.IdNotFoundException;
import com.wu.ecommerce.exceptions.InvalidIdException;
import com.wu.ecommerce.exceptions.InvalidPriceException;

public interface ProductRepository {
	
	public Product addProduct(Product product) throws SQLException;

	public Product getProdcutByProductId(String id) throws IdNotFoundException, SQLException;
	public List<Product> getProduct() throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	public List<Product> getProductByCategory(String category) throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException;
	
	public String removeProductByProductId(String id) throws IdNotFoundException, SQLException;
	public Product updateProductByProductId(String id, Product product) throws IdNotFoundException, SQLException;
	
	default void display()
	{
		System.out.println("Hello JI");
	}

}

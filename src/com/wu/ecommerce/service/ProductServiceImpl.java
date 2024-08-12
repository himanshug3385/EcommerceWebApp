package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exceptions.DataNotFoundException;
import com.wu.ecommerce.exceptions.IdNotFoundException;
import com.wu.ecommerce.exceptions.InvalidIdException;
import com.wu.ecommerce.exceptions.InvalidPriceException;
import com.wu.ecommerce.repo.ProductRepository;
import com.wu.ecommerce.repo.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {

//	private static ProductService productService;
//	
//  private ProductServiceImpl() {
//	// TODO Auto-generated constructor stub
//	  
//	  if(productService == null)
//	  {
//		  
//	  }
//}

//	Imp Line Focus on this to change the repository implementation
	private ProductRepository productRepository = ProductRepositoryImpl.getInstance();

	private static ProductService productService;

	private ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public static ProductService getInstance() {

		if (productService == null) {
			productService = new ProductServiceImpl();
		}

		return productService;

	}

	@Override
	public Product addProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return productRepository.addProduct(product);
	}

	@Override
	public Product getProdcutByProductId(String id) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return productRepository.getProdcutByProductId(id);
	}

	@Override
	public List<Product> getProduct() throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		return productRepository.getProduct();
	}

	@Override
	public List<Product> getProductByCategory(String category) throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		return productRepository.getProductByCategory(category);
	}

	@Override
	public String removeProductByProductId(String id) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return productRepository.removeProductByProductId(id);
	}

	@Override
	public Product updateProductByProductId(String id, Product product) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return productRepository.updateProductByProductId(id, product);
	}

}

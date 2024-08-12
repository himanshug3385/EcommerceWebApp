package com.wu.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exceptions.DataNotFoundException;
import com.wu.ecommerce.exceptions.IdNotFoundException;
import com.wu.ecommerce.exceptions.InvalidIdException;
import com.wu.ecommerce.exceptions.InvalidPriceException;
import com.wu.ecommerce.utils.DbUtils;
import com.wu.ecommerce.utils.IdComparator;

public class ProductRepositoryImpl implements ProductRepository {

	private ProductRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

//	private Set<Product> products = new TreeSet<Product>(new Comparator<Product>() {
//
//		@Override
//		public int compare(Product o1, Product o2) {
//			// TODO Auto-generated method stub
//			return o1.getProductName().compareTo(o2.getProductName());
//		}
//	});
	
	private TreeSet<Product> products = new TreeSet<Product>((o1, o2) -> o1.getProductName().compareTo(o2.getProductName()));

	private static ProductRepository productRepository;

	public static ProductRepository getInstance() {

		if (productRepository == null) {
			productRepository = new ProductRepositoryImpl();
		}

		return productRepository;
	}

	@Override
	public Product addProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
//		products.forEach(e -> System.out.println(e));
		
		Connection connection = DbUtils.getInstance().getConnection();
		
//		System.out.println(connection);
		
		String str = "insert into product (PRODUCTID, PRODUCTNAME, PRICE, CATEGORYNAME) values (?, ? , ? , ? )";
		
		PreparedStatement preparedStatement = connection.prepareStatement(str);
		preparedStatement.setString(1, product.getProductId());
		preparedStatement.setString(2, product.getProductName());
		preparedStatement.setFloat(3,  product.getPrice());
		preparedStatement.setString(4, product.getCategoryName());
		
	 int rowUpdated = preparedStatement.executeUpdate();
	 
	 if(rowUpdated > 0)
	 {
		 System.out.println("Product Inserted Successfully");
	 }
	 else
	 {
		 System.out.println("Failure");
	 }
		
	 
		return product;
	}

	@Override
	public Product getProdcutByProductId(String id) throws IdNotFoundException, SQLException {
		
		Connection connection = DbUtils.getInstance().getConnection();
		
		String sql = "select * from product where PRODUCTID = ? ";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			System.out.println(resultSet.getString(1));
		}
		else
		{
			System.out.println("dard");
		}
         
		
		// TODO Auto-generated method stub
//		final Product p = null;
//		
//		products.forEach(e -> {
//			if( e.getProductId().equals(id))
//			{
//				p = e;
//			}
//		});

//		Product p = null;

		return null;
//		
//		return Optional.empty();
	}

	@Override
	public List<Product> getProduct() throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		// TODO Auto-generated method stub
		// List may be empty

//		return Optional.ofNullable(products.stream().collect(Collectors.toList())).filter(e -> !e.isEmpty())
//				.orElseThrow(() -> new DataNotFoundException("There is no Data"));
		
		List<Product> newProduct = new ArrayList<Product>();
		
        Connection connection = DbUtils.getInstance().getConnection();
		
		String sql = "select * from product";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next())
		{
//			System.out.println(resultSet.getString("PRODUCTID"));
			
			Product product = new Product();
			
			product.setProductId(resultSet.getString("PRODUCTID"));
			product.setCategoryName(resultSet.getString("CATEGORYNAME"));
			product.setPrice(resultSet.getFloat("PRICE"));
			product.setProductName(resultSet.getString("PRODUCTNAME"));
			
		newProduct.add(product);
		}
		
		return newProduct;
	}

	@Override
	public List<Product> getProductByCategory(String category) throws DataNotFoundException, SQLException, InvalidIdException, InvalidPriceException {
		Connection connection = DbUtils.getInstance().getConnection();
		
		String sql = "select * from product where CATEGORYNAME = ? ";
		
		List<Product> newProduct = new ArrayList<Product>();
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, category);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		

			while(resultSet.next())
			{
//				System.out.println(resultSet.getString("PRODUCTID"));
				
				Product product = new Product();
				
				product.setProductId(resultSet.getString("PRODUCTID"));
				product.setCategoryName(resultSet.getString("CATEGORYNAME"));
				product.setPrice(resultSet.getFloat("PRICE"));
				product.setProductName(resultSet.getString("PRODUCTNAME"));
				
			newProduct.add(product);
			}
			
			return newProduct;
		
	
	}

	@Override
	public String removeProductByProductId(String id) throws IdNotFoundException, SQLException {
		// TODO Auto-generated method stub
//		Product product = this.getProdcutByProductId(id);

//		boolean result = products.remove(product);
//
//		if (result) {
//			return "Deleted Product";
//		}
		
        Connection connection = DbUtils.getInstance().getConnection();
		
		String sql = "delete from product where PRODUCTID = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, id);
		
		int res = preparedStatement.executeUpdate();
		
		if(res > 0)
		{
			System.out.println("Deleted Brother");
		}

		return "Falied";
	}

	@Override
	public Product updateProductByProductId(String id, Product product) throws SQLException {
		// TODO Auto-generated method stub

//		for (Product pr : products) {
//			if (pr.getProductId().equals(id)) {
//				pr = product;
//			}
//		}
//
//		return product;
		
		Connection connection = DbUtils.getInstance().getConnection();
		
		String sql = "update product set PRODUCTNAME = ? , PRICE = ?, CATEGORYNAME = ? where PRODUCTID = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, product.getProductName());
		preparedStatement.setFloat(2, product.getPrice());
		preparedStatement.setString(3, product.getCategoryName());
		preparedStatement.setString(4, product.getProductId());
		
		
		int result = preparedStatement.executeUpdate();
		
		if(result > 0)
		{
			System.out.println("Updated Brother");
		}
		else
		{
			System.out.println("Dard bhai");
		}
		
		return null;
	}

}

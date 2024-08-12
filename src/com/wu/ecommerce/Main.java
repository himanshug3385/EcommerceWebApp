package com.wu.ecommerce;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.wu.ecommerce.dto.Order;
import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.Users;
import com.wu.ecommerce.exceptions.DataNotFoundException;
import com.wu.ecommerce.exceptions.IdNotFoundException;
import com.wu.ecommerce.exceptions.InvalidIdException;
import com.wu.ecommerce.exceptions.InvalidPriceException;
import com.wu.ecommerce.service.OrderService;
import com.wu.ecommerce.service.OrderServiceImpl;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;

public class Main {
	
	public static void addProduct(ProductService productService, Scanner sc) throws InvalidIdException, InvalidPriceException, SQLException
	{
		
		
		System.out.println("ENTER THE PRODUCT ID");
		String id = sc.next();
		System.out.println("Enter the product Name");
		String name = sc.next();
		System.out.println("Enter the Product Price");
	    float price = sc.nextFloat();
	    System.out.println("Enter the Category");
	    String cat = sc.next();
	    
	    Product pr = new Product(id, name, price, name);
	    
	    productService.addProduct(pr);
	    
	}
	
	public static void updateProduct(ProductService productService, Scanner sc) throws InvalidIdException, InvalidPriceException, IdNotFoundException, SQLException
	{
		
		System.out.println("ENTER THE PRODUCT ID Which u want to update");
		String id = sc.next();
		
		System.out.println("Enter the details");
		System.out.println("-------------------");
		System.out.println("Enter the product Name");
		String name = sc.next();
		System.out.println("Enter the Product Price");
	    float price = sc.nextFloat();
	    System.out.println("Enter the Category");
	    String cat = sc.next();
	    
	    Product pr = new Product(id, name, price, cat);
	    
	    productService.updateProductByProductId(id, pr);
		
	}
	
	public static void deleteTheProduct(ProductService productService, Scanner sc) throws InvalidIdException, InvalidPriceException, IdNotFoundException, SQLException
	{
		System.out.println("Enter the product id");
		String id = sc.next();
		
		productService.removeProductByProductId(id);
	}
	
	public static void getProductByProductId(ProductService productService, Scanner sc) throws InvalidIdException, InvalidPriceException, IdNotFoundException, SQLException, DataNotFoundException
	{
		System.out.println("Enter the Product Id bro");
		String id = sc.next();
		
	 System.out.println(productService.getProdcutByProductId(id)); 	
	}
	
	
	public static void getProductByCategory(ProductService productService, Scanner sc) throws InvalidIdException, InvalidPriceException, IdNotFoundException, SQLException, DataNotFoundException
	{
		System.out.println("Enter the Product Category bro");
		String cat = sc.next();
		
	 List<Product> ans = productService.getProductByCategory(cat);
	 
	 ans.forEach(e -> System.out.println(e));
		
	}
	
	public static void getAllProducts(ProductService productService, Scanner sc) throws InvalidIdException, InvalidPriceException, IdNotFoundException, SQLException, DataNotFoundException
	{
		System.out.println("Product List as follows");
		
	 List<Product> ans = productService.getProduct();
	 
	 ans.forEach(e -> System.out.println(e));
		
	}
	
	public static void main(String[] args) throws Exception {
		ProductService productService = ProductServiceImpl.getInstance();
		OrderService orderService = OrderServiceImpl.getInstance();
		UserService userService = UserServiceImpl.getInstance();
		
//		userService.addUser(new Users(1, 2, "Dard", "fsadsad"));
		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

//		System.out.println(orderService.addOrder(new Order("order01", "tapakDham", "user01", "Anish", "Powar")));
//		
//		productService.addProduct(new Product("Prod01", "Washing Powder", 89, "Detergent"));

//		for(int i =0; i<=11; i++)
//		{
//			productService.addProduct(new Product("prod123", "Washing", i, "Kitchen"));
//			System.out.println("Demo");
//		}

//			try {
//				Product pr = new Product("ghhj", "asda", 2, "cat1");
//				Product bv = new Product("ghhj", "asda", 2, "cat1");
//				
//				System.out.println(pr.equals(bv));
//				
//				System.out.println(pr.hashCode() + " For pr object");
//				System.out.println(bv.hashCode() + " For bv object");
//				
//				
////				System.out.println(pr.toString());
////				System.out.println(pr.hashCode());
////				System.out.println(Integer.toHexString(pr.hashCode()));
//				
//			} catch (InvalidPriceException e) {
//				// TODO: handle exception
//				System.out.println(e.getMessage());
//			}

//		System.out.println(productService.getProdcutByProductId("prod123"));

//		Optional<Product []> demo = productService.getProduct();
//		
//		if(demo.isPresent())
//		{
//			Product[] newa =  demo.get();
//			for (Product product : newa) {
//				if(product != null)
//				{
//					System.out.println(product);
//				}
//			}
//			}
//		Optional<Product[]> result = productService.getProductByCategory("Stationary");
//		
//		if(result.isPresent())
//		{
//			Product[] newa =  result.get();
//			for (Product product : newa) {
//				if(product != null)
//				{
//					System.out.println(product);
//				}	
//			}
//		}	

//		Alag Entity
//		Product products[] = new Product[10];
//	     System.out.println(products.length);
//		
//		for (Product product : products) {
//			
//			System.out.println(product);
//		}
//		productService.removeProductByProductId("prod34");
//		
//		try {
//			System.out.println("Dard ye disco");
//			System.out.println(productService.getProdcutByProductId("890tt"));
//		}
//		catch(NullPointerException e)
//		{
//			System.out.println(e.getMessage());
//			int a = 10/0;
//			System.out.println("Product for provided id is not found");
//		}
//		catch (ArithmeticException e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//			
//		}
//		catch(RuntimeException re)
//		{
//			
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//		
//		catch(Throwable th)
//		{
//			System.out.println(th.getMessage());
//		}
//		
////		catch(Object ob)
////		{
////			
////		}     Not allowed , why ? => if allowed, Throwable will loose its importance;
//		
//		finally {
//			System.out.println("Hmmm");
//		}

//		
//		System.out.println(productService.addProduct(new Product("uioj", "Dard123", 18, "Jindagi")));
//		System.out.println(productService.addProduct((new Product("Abcsd78", "Dard", 90, "Life")));

//		System.out.println(productService.addProduct(new Product("Abcsd78", "Dard", 90, "Life")));
//	productService.addProduct(new Product("uiodbj1fd26", "Dard123", 18, "Jindagi"));
	
//	productService.getProdcutByProductId("uiobj");
	
  List<Product> result = productService.getProduct();
  
//  result.forEach(e -> System.out.println(e));

  
// List<Product> ans =   productService.getProductByCategory("cadsd");
// 
// ans.forEach(e -> System.out.println(e));
//		
	productService.removeProductByProductId("uiobj1d2");
		
		
//		productService.updateProductByProductId("uiobj", new Product("uiobj", "ywqudi", 4, "asdnajdna"));
		
		
//		productService.addProduct(new Product("uifsdfoj", "Dard123", 18, "Jindagi"));

//		try {
//			 System.out.println(productService.getProdcutByProductId("Abcsd78"));
//		} catch (IdNotFoundException e) {
//			// TODO: handle exception
//			
//			System.out.println(e.getMessage());
//		}
//		
//		
//		try {
//			List<Product> li = productService.getProduct();
//
//			li.forEach(e -> System.out.println(e));
//		} catch (DataNotFoundException de) {
//			System.out.println(de.getMessage());
//		}
//		
//		
//		try {
//			
//			List<Product> result = productService.getProductByCategory("Life");
//			 System.out.println("Dard");
//			result.forEach(e -> System.out.println(e));
//		} catch (DataNotFoundException e2) {
//			// TODO: handle exception
//			System.out.println(e2.getMessage());
//		}

//		Optional allDet = productService.getProduct();
//		ArrayList<Product> demo = (ArrayList<Product>) allDet.get();
//		System.out.println("below is whole list of product");	
//		demo.forEach(e -> {
//			System.out.println(e);
//		});

//		System.out.println(productService.removeProductByProductId("Abcsd78"));

		int choice = 0;

//		productService.addProduct(new Product("Abcsd78", "Dard", 9018, "Life"));

		Scanner sc = new Scanner(System.in);

//		while(true)
//		{
//			System.out.println("Enter the Choice");
//			choice = sc.nextInt();
//			
//			String id, name, cat;
//			float price;
//			
//			switch(choice)
//			{
//			
//			case 1: 
//				System.out.println("Enter your product details");
//				System.out.println("Enter the Product Id");
//				id = sc.next();
//				System.out.println("Enter the Product Name");
//				name = sc.next();
//				System.out.println("Enter the Product Price");
//				price = sc.nextInt();
//				System.out.println("Enter the Product Category");
//				cat = sc.next();
//				
//				Product newProd = new Product(id,name,price,cat);
//				
//				productService.addProduct(newProd);
//				
//				break;
//			
//			}

//		}
		
		boolean start = true;
		
		
		while(start)
		{
			System.out.println("1. Add Product");
			System.out.println("2. Edit Product");
			System.out.println("3. Delete Product");
			System.out.println("4. Get Product by Category");
			System.out.println("5. Get Product by Product ID");
			System.out.println("6. Get All Product");
			System.out.println("7. Exit");
			System.out.println("Enter your Choice");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				addProduct(productService, sc);
				break;
				
			case 2: 
				updateProduct(productService, sc);
				break;
				
			case 3 : 
				deleteTheProduct(productService, sc);
				break;
				
			case 4:
				getProductByCategory(productService, sc);
				break;
			case 5:
				getProductByProductId(productService, sc);
				break;
				
			case 6:
				getAllProducts(productService, sc);
				break;
				
			case 7:
				start = false;
				break;

			default:
				break;
			}
		}
		

	}

}

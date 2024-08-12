package com.wu.ecommerce.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.Users;
import com.wu.ecommerce.exceptions.InvalidIdException;
import com.wu.ecommerce.exceptions.InvalidPriceException;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;

/**
 * Servlet implementation class AddProductToCart
 */
@WebServlet(urlPatterns = "/addProduct", name = "AddProductToCart")
public class AddProductToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/addProduct.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
         
		 Product product= new Product();
		 ProductService productService= ProductServiceImpl.getInstance();
		 String name = request.getParameter("name");
		String price = request.getParameter("price");
		String category= request.getParameter("category");
		
		if(name.isEmpty() || price.isEmpty() || category.isEmpty())
		{
			System.out.println("FIll it bro");
		}
		try {
			product.setProductId("sdsff");
		} catch (InvalidIdException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		product.setCategoryName(category);
		try {
			product.setPrice(Float.parseFloat(price));
		} catch (NumberFormatException | InvalidPriceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		product.setProductName(name);
		Product copy=null;
		try {
			
			copy= productService.addProduct(product);
			if(copy!=null) {
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/dashBoard.jsp");
				//dispatcher.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	
		System.out.println(product);
	}

}

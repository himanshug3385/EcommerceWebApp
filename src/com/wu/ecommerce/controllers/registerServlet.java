package com.wu.ecommerce.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.dto.Users;
import com.wu.ecommerce.exceptions.DataNotFoundException;
import com.wu.ecommerce.exceptions.InvalidIdException;
import com.wu.ecommerce.exceptions.InvalidPriceException;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
		
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		Users users = new Users();
		
		UserService userService = UserServiceImpl.getInstance();
		ProductService productservice= ProductServiceImpl.getInstance();
		//System.out.println("Hello ji kaisan ba, post call hua he");
		
	    
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		
		if(email.isEmpty())
		{
			System.out.println("FIll it bro");
		}
		else
		{
			users.setLastName(email);
		}
		
		if(password.isEmpty())
		{
			System.out.println("Fill it bro");
		}
		else
		{
			users.setFirstName(password);
		}
		
		users.setUserID(10);
		Users user2=null;
		try {
			
			user2= userService.addUser(users);
			if(user2!=null) {
				List<Product>productList=  productservice.getProduct();
				ServletContext servletContext= request.getServletContext();
				servletContext.setAttribute("productDetails", productList);
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("user", user2);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/dashBoard.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPriceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	
		System.out.println(users);
		
		
	}

}

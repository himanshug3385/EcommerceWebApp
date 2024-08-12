<%@page import="com.wu.ecommerce.dto.Users"%>
<%@page import="com.wu.ecommerce.dto.Product" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>This is the Dashboard</h1>
<table>
<%

 Users user=  (Users)session.getAttribute("user");
out.println(user);
List<Product> productList= (List<Product>)application.getAttribute("productDetails");
//out.print(productList);

//productList.forEach(e->{try{out.print(e);}catch(Exception e2){}});


for(Product pro:productList){
%>
<tr><td><%out.print(pro.getProductId()); %> </td> <td><%out.print(pro.getProductName()); %> </td></tr>

<%} %>

</table>
<h1>Hello ,<%= user.getFirstName()+ user.getLastName() %> </h1>
<a href="addProduct">Add Product To Cart</a>
<a href="logout">logout</a>

</body>
</html>
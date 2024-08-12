<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addProduct" method = "post" style="border:1px solid #ccc">
  <div class="container">
    <h1>Add Product </h1>
    <p>Please fill in this form to Add Product.</p>
    <hr>
        
    <label for="name"><b>Product Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required>

    <label for="price"><b>Product Price</b></label>
    <input type="number" placeholder="Enter Price" name="price" required>

    <label for="category"><b>Product Category</b></label>
    <input type="text" placeholder="Enter Category" name="category" required>

    

    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Add Product</button>
    </div>
  </div>
</form>
</body>
</html>
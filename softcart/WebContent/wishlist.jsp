<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="logic.*"%>
<jsp:useBean id= "tranlist" scope= "page"  class= "logic.ProductSort" type= "logic.ProductSort" >  </jsp:useBean>
<%
UserDetails user = (UserDetails)request.getSession().getAttribute("user");
if(user==null){
	System.out.println( "unknown ");
	response.sendRedirect("login.jsp");
	
}
else if(user.getRole().equals("admin"))
{
  response.sendRedirect("admin.jsp");
}
else if(user.getRole().equals("user"))
{

}
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Soft Cart</title>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <!-- <link rel="stylesheet" href="./bootstrap/bootstrap.min.css">
  <script src="./bootstrap/jquery-1.8.3.min.js"></script>
  <script src="./bootstrap/bootstrap.min.js"></script>-->
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */
    .navbar {
      margin-bottom: 30px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */
     .jumbotron {
      margin-bottom: -30px;
      margin-top: -30px;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    #phead{
    background-color: #bd2031;
    }
  </style>
</head>
<body>

<div class="jumbotron">
  <div class="container text-center">
    <a href="#" class="pull-center"><img src="./images/softlogo.png"></a> 
  </div>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">Home</a></li>
        <li><a href="index.jsp">Products</a></li>
        <li><a href="wishlist.jsp">Wish List</a></li>
        <li><a href="orderhistory.jsp">Order History</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
<button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown">
<span class="glyphicon glyphicon-user"></span> <%= user.getUsername() %>
<span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="logout.jsp">logout</a></li>
    <li><a href="orderhistory.jsp">Order History</a></li>
    
  </ul>

  

</li>
        <li><a href="cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    </div>
  </div>
</nav>
</head>
<body>
<div class="col-sm-12">
<h1>Your Wish List</h1>
<div class="row">
<div class="col-sm-8">
<table class="table">
    <thead>
      <tr>
        <th>Product</th>
        <th>Product_ID</th>
        <th>Product Name</th>
        <th>Product Price</th>
       
        <th>Description</th>
        <th>Change</th>
        
      </tr>
    </thead>
    <tbody>
    
<%  for (TransactionDetails td : tranlist.getTrans(user.getId(),1))  {%>


      <tr>
        <td><a href="<%= td.getImage() %>" ><IMG SRC="<%= td.getImage() %>"  WIDTH="50" HEIGHT="50" /></a></td>
        <td><%= td.getIdProduct() %></td>
        <td><%= td.getName() %></td>
        <td><%= td.getPrice() %></td>
       
        <td><%= td.getDescription() %></td>
        <td> 
        <a href="LogServlet?log=cart&userid=<%= user.getId()%>&prodid=<%= td.getIdProduct() %>" class="btn btn-info" role="button">Add to Cart</a>
        <a href="LogServlet?log=wishdelete&tranid=<%= td.getId()%>" class="btn btn-info" role="button">Delete</a></td>
      </tr>
<% }%>
    </tbody>
  </table>
  </div>
  
  
 
  </div>
  </div>
</body>
</html>
</head>
<body>


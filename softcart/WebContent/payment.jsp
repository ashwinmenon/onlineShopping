<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="logic.*"%>
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
     <li><a href="userprofile.jsp">Profile</a></li>
    <li><a href="orderhistory.jsp">Order History</a></li>
    <li><a href="logout.jsp">logout</a></li>
    
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
<h1>Payment Gateway SoftCart</h1>
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-6">
<h3>Payment Mode</h3>

<form>
<select class="span3" name="paymode">
 
    <option value="credit">Credit Card</option>
    <option value="debit">Debit Card</option>
  </select>
<br>
Name on Card:<input type="text" name="cardname"/><br>
Card No:<input type="text" name="cardno"/><br>
Card Expiry Date: 
<select class="span3" name="expiry_month" id="expiry_month">
                <option></option>
                <option value="01">Jan (01)</option>
                <option value="02">Feb (02)</option>
                <option value="03">Mar (03)</option>
                <option value="04">Apr (04)</option>
                <option value="05">May (05)</option>
                <option value="06">June (06)</option>
                <option value="07">July (07)</option>
                <option value="08">Aug (08)</option>
                <option value="09">Sep (09)</option>
                <option value="10">Oct (10)</option>
                <option value="11">Nov (11)</option>
                <option value="12">Dec (12)</option>
              </select>
              <select class="span2" name="expiry_year">
                <option value="13">2013</option>
                <option value="14">2014</option>
                <option value="15">2015</option>
                <option value="16">2016</option>
                <option value="17">2017</option>
                <option value="18">2018</option>
                <option value="19">2019</option>
                <option value="20">2020</option>
                <option value="21">2021</option>
                <option value="22">2022</option>
                <option value="23">2023</option>
              </select><br>
Card CVV: <input type="password" name="cardno"/>
<br>
----OR---
<br>

  <label><input type="radio" name="cod">Cash On Delivery</label><br>
<input type="submit" value="checkout1" name="log" />
</form>
</div>
<div class="col-sm-3">
Order Details:<br>
<%=request.getParameter("idUser")%>
<%=request.getParameter("orders")%>
<%=request.getParameter("total")%>
<%=request.getParameter("optradio")%>
</div>
</body>
</html>
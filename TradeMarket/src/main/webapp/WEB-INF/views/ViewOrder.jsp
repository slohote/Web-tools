<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */
     .jumbotron {
      margin-bottom: 0;
      background-color: currentColor;
      padding-top: 28px;
    padding-bottom: 12px;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>
<div class="jumbotron">
  <div class="container text-center">
    <h1 style="background-color: cadetblue;">Fidelity</h1>
    <p>Trading Window</p>
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
      <a class="navbar-brand" href="#">FD</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="viewstocks.htm">Market Watch</a></li>
        <li><a href="viewwatchlist.htm">View WatchList</a></li>
        <li><a href="viewownedstock.htm">Owned Stocks</a></li>
        <li><a href="buyequity.htm">Buy Equity</a></li>
        <li><a href="#">Latest Stock Events</a></li>
        <li><a href="viewtradeorder.htm">View Trade Orders</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <li><span class="glyphicon glyphicon-user" > Welcome ${user.firstName}<b>&nbsp;Login time :&nbsp; <font color="#FF0000">
	<%= new java.util.Date() %>
	</font></b></span></li>
        <li><a href="logout.htm"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
        
      </ul>
    </div>
  </div>
</nav>
<h2 style="font-size: 24px;
    font-style: italic;
    font-variant: small-caps;">Your Trade Orders on exchange:</h2>
<center>
<table border=1 style="align-content: center;
    color: whitesmoke;
    background-color: black;">

             
             <tr> 
              <th>Generate Invoice</th> 
              <th>StockId  </th> 
              <th>Buy Date  </th> 
             <th>Buy Price </th>
              <th>Sell Date  </th> 
               
              <th>Sell Price   </th>
              <th>Quantity   </th>
              <th>Instrument   </th>
              <th>Status   </th>
              <th>Trigger Price   </th>
              
              </tr> 
              <c:forEach var="order" items="${stocks}"> 
                 <tr>
                 <td><a href="viewpdfreport.pdf?id1=${order.orderId}" >${order.orderId}</a></td>  
                     <td><a href="viewcurrentrates.htm?id=${order.stockInfo.stockId}" >${order.stockInfo.stockId}</a></td> 
                     <td>${order.buyDate}</td> 
                    <td>${order.buyPrice}</td> 
                     <td>${order.sellDate}</td> 
                    <td>${order.sellPrice}</td> 
                    <td>${order.qty}</td> 
                    <td>${order.instrument}</td>
                    <td>${order.status}</td>
                    <td>${order.triggerPrice}</td>
                    
                 </tr> 
             </c:forEach>
              
            
             </table>
</center>
</body>
</html>
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
    <p>Mission, Vision & Values</p>
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
        <li class="active"><a href="addstock.htm">Initial public offering(IPO)</a></li>
        <li><a href="marketwatch.htm">Market watch</a></li>
        <li><a href="currentMarket.htm">Current Market Offering</a></li>
        <li><a href="stockdisplay.htm">Stock Events Updates</a></li>
        <li><a href="setpd.htm">Trader - Probability Of default</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <li><span class="glyphicon glyphicon-user" > <b>&nbsp;Login time :&nbsp; <font color="#FF0000">
	<%= new java.util.Date() %>
	</font></b></span></li>
        <li><a href="logout.htm"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
        
      </ul>
    </div>
  </div>
</nav>
<h3>Current Market Updates</h3>
<div id="results">
<center>
             <table border=1 style="align-content: center;
    color: whitesmoke;
    background-color: black;">
             <tr>
             <th>Stock ID  </th>
             <th>Stock Name  </th>
             <th>Short name  </th>
             
             <th>Market value  </th>
             <th>Limit value  </th>
             <th>Updation</th>
             
             </tr>
             <c:forEach var="stock" items="${stocks}">
                <tr>
                    <td>${stock.stockId}</td>
                    <td>${stock.stockName}</td>
                    <td>${stock.shortName}</td>
                    <td>${stock.marketValue}</td>
                    <td>${stock.limitValue}</td>
                    <td><a href="updaterate.htm?id=${stock.stockId}">Update Current Rates</a></td>
                </tr>
            </c:forEach>
            
             </table>
             </center>
            </div>

</body>
</html>
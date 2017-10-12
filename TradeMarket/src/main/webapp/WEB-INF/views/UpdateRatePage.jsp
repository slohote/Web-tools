<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<center>
<form:form action="updaterate.htm" commandName="stockCurrentInfo" method="post">

<table>
<tr>
    <td>Stock Id:</td>
    <td><form:input path="stockId" value="${stock}" size="30" /> <font color="red"><form:errors path="stockId"/></font></td>
</tr>

<tr>
    <td>Date:</td>
    <td><form:input type="text" name="timestamp" value="<%=new java.util.Date()%>"  path="date" /> <font color="red"><form:errors path="date"/></font></td>
</tr>

<tr>
    <td>Open Price:</td>
    <td><form:input type="text" path="openPrice" size="30" /> <font color="red"><form:errors path="openPrice"/></font></td>
</tr>


<tr>
    <td>Current Price:</td>
    <td><form:input type="text" path="currentPrice" size="30" /> <font color="red"><form:errors path="currentPrice"/></font></td>
</tr>

<tr>
    <td>Highest Price on day:</td>
    <td><form:input type="text" path="highest" size="30" /> <font color="red"><form:errors path="highest"/></font></td>
</tr>

<tr>
    <td>Lowest Price on day:</td>
    <td><form:input type="text" path="lowest" size="30" /> <font color="red"><form:errors path="lowest"/></font></td>
</tr>

<tr>
    <td>Total Exchange Qty:</td>
    <td><form:input type="text" path="totalExchangeQty" size="30" /> <font color="red"><form:errors path="totalExchangeQty"/></font></td>
</tr>

 
<tr>
    <td colspan="2"><input type="submit" value="Add Current Rates" style="margin-left:100px;background-color: black;color: white;"/></td>
</tr>
</table>

</form:form>
</center>

 



</body>
</html>
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
<script>
//AJAX

var xmlHttp;
xmlHttp = GetXmlHttpObject();

function display() {
    if (xmlHttp == null)
    {
        alert("Your browser does not support AJAX!");
        return;
    }
    alert("hi");
    var key = document.getElementById("stock");
    var strUser = key.options[key.selectedIndex].value;
    alert("option"+strUser);
   // var flag = document.querySelector('input[name = "search"]:checked').value;
    var query = "key=" + strUser.trim() ;
    xmlHttp.onreadystatechange = function stateChanged()
    {
        if (xmlHttp.readyState == 4)
        {
        	alert("shubh\n"+xmlHttp.responseText);
            document.getElementById("results").innerHTML = "";
            var json = JSON.parse(xmlHttp.responseText);
            alert("lenght" +json.users.length );
            if (json.users.length > 0) {
            	 
            //alert("inside");
                var x = document.createElement("TABLE");
                x.setAttribute("id", "myTable");
                x.setAttribute("border","1 solid black");
                document.getElementById("results").appendChild(x);
                var y = document.createElement("TR");
                y.setAttribute("id", "myTr");
                document.getElementById("myTable").appendChild(y);

                var z = document.createElement("TH");
                var t = document.createTextNode("date");

                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);

                var z = document.createElement("TH");
                var t = document.createTextNode("openPrice");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);
                 
                 
                 var z = document.createElement("TH");
                var t = document.createTextNode("currentPrice");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);

                var z = document.createElement("TH");
                var t = document.createTextNode("highest rate on day");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);  
                
                var z = document.createElement("TH");
                var t = document.createTextNode("Lowest rate on day");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);
                
                var z = document.createElement("TH");
                var t = document.createTextNode("total Exchange Qty");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);
                
                
               //alert("lenght" +json.users.length );
                

                for (var count = 0; count < json.users.length; count++) {
                	 alert("-------->" +json.users );
                    var y = document.createElement("TR");
                    y.setAttribute("id", "myTr" + count);
                    document.getElementById("myTable").appendChild(y);

                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.users[count].date);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);

                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.users[count].openPrice);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);

                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.users[count].currentPrice);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);

                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.users[count].highest);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);
                    
                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.users[count].lowest);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);
                    
                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.users[count].totalExchangeQty);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);
                    
                }
		}
    else {
       document.getElementById("results").innerHTML="Nothing Found";
   }
        }
};
xmlHttp.open("POST", "searchStock.htm", true);
xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xmlHttp.send(query);
return false;
}


function GetXmlHttpObject()
{
	alert("hi3");
    var xmlHttp = null;
    try
    {
        // Firefox, Opera 8.0+, Safari
        xmlHttp = new XMLHttpRequest();
    } catch (e)
    {
        // Internet Explorer
        try
        {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttp;
}

</script>
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
    font-variant: small-caps;">View Equity watchlist</h2>
<div id="selection">
                       <c:choose>
                            <c:when test="${!empty sessionScope.output}">

                              <select id="stock" onchange="return display();">

                            <c:forEach var="stock" items="${sessionScope.output}">
                                <option value="${stock.stockId}">${stock.stockName}</option>
                            </c:forEach>
                        </select>
                        </c:when>    
                  <c:otherwise>
                      <p>Watchlist is empty</p>
                  </c:otherwise>  
                      </c:choose>
</div>
<div id="results">





</div>

</body>
</html>
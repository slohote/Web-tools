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
<script type="text/javascript">
		var xmlHttp;
	    xmlHttp = GetXmlHttpObject();
	    
	function getResults() {
		alert("Hello");
		document.getElementById("searchedResult").style.display = "block";
		document.getElementById("allResults").style.display = "none";
		
        if (xmlHttp == null)
        {
            alert("Your browser does not support AJAX!");
            return;
        }
        alert("hi2");
        var key = document.getElementById("name").value;
        alert("key" + key);
        var flag = document.querySelector('input[name = "search"]:checked').value;
        alert("flag" + flag);
        var query = "action=searchuser&key=" + key.trim() + "&flag=" + flag.trim();
        xmlHttp.onreadystatechange = function stateChanged()
        {
         	if (xmlHttp.readyState == 4){
             document.getElementById("searchedResult").innerHTML = "";
             var json = JSON.parse(xmlHttp.responseText);
             if (json.users.length > 0) {
                 

                 for (var count = 0; count < json.users.length; count++) {
                     var y = document.createElement("TR");
                     y.setAttribute("id", "myTr" + count);
                     document.getElementById("myTable").appendChild(y);

                     var z = document.createElement("TD");
                     var t = document.createTextNode(json.users[count].stockId);
                     z.appendChild(t);
                     document.getElementById("myTr" + count).appendChild(z);

                     var z = document.createElement("TD");
                     var t = document.createTextNode(json.users[count].stockName);
                     z.appendChild(t);
                     document.getElementById("myTr" + count).appendChild(z);

                     var z = document.createElement("TD");
                     var t = document.createTextNode(json.users[count].shortName);
                     z.appendChild(t);
                     document.getElementById("myTr" + count).appendChild(z);

                     var z = document.createElement("TD");
                     var t = document.createTextNode(json.users[count].marketValue);
                     z.appendChild(t);
                     document.getElementById("myTr" + count).appendChild(z);
                     
                     var z = document.createElement("TD");
                     var t = document.createTextNode(json.users[count].limitValue);
                     z.appendChild(t);
                     document.getElementById("myTr" + count).appendChild(z);
                     
                    
                     var z = document.createElement("TD");
                     var a = document.createElement('a');
                     var id = json.users[count].id;
                     var rowID = "myTr" + count;
                     var linkText = document.createTextNode("Delete");
                     a.appendChild(linkText);
                     a.title = "Delete";
                     a.onclick = (function (id, rowID) {
                         return function () {
                             deleteRow(id, rowID);
                         }
                     })(id, rowID);
                     z.appendChild(a);
                     document.getElementById("myTr" + count).appendChild(z);
                 }
            }
			else {
                document.getElementById("searchedResult").innerHTML="Nothing Found";
            }
         	}
   	    };
   	    xmlHttp.open("POST", "searchSpecificStock.htm", true);
   	    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
 	    xmlHttp.send(query);
		return false;
    }
		
    function deleteRow(userID, rowID) {
        if (xmlHttp == null)
        {
            alert("Your browser does not support AJAX!");
            return;
        }

        var query = "action=delete&user=" + userID;

        xmlHttp.onreadystatechange = function stateChanged()
        {
            if (xmlHttp.readyState == 4)
            {
                var row = document.getElementById(rowID);
                row.parentNode.removeChild(row);
            }
        };
        xmlHttp.open("POST", "searchSpecificStock.htm", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send(query);
        return false;
    }

    function GetXmlHttpObject()
    {
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
<div><h2>Stock Watch</h2>
</div>
<center>
<div id="searchForm" >
            
<!--             <form id="search" onsubmit="return getResults()"> -->

                Search Stock <input type="text" id="name" name="stock" onkeyup="getResults()" /> <br><br>

                <label>Search By:</label>
                <input type="radio" name="search" value="stockName" checked="checked"> Stock Name
                <input type="radio" name="search"  value="shortName"> Short Name
                
<!--                 <input type="submit" name="search" style="margin-left:100px;background-color: black;color: white;"/><br><br> -->
<!--             </form> -->
            <div id="child" style="display: none;">
            
            
            </div>
            </div>
            <div id="results">
             <table id="myTable" border=1 style="align-content: center;
    color: whitesmoke;
    background-color: black;">
    			<thead>
             <tr>
             <th>Stock ID  </th>
             <th>Stock Name  </th>
             <th>Short name  </th>
             
             <th>Market value  </th>
             <th>Limit value  </th>
             <th>Add Events</th>
             
             </tr>
             </thead>
             <tbody id="allResults">
             <c:forEach var="stock" items="${stocks}">
                <tr>
                    <td>${stock.stockId}</td>
                    <td>${stock.stockName}</td>
                    <td>${stock.shortName}</td>
                    <td>${stock.marketValue}</td>
                    <td>${stock.limitValue}</td>
                    <td><a href="addevent.htm?id=${stock.stockId}">Add Current Event</a></td>
                    <td><a href="deletestock.htm?id=${stock.stockId}">Delete stock</a> </td>
                </tr>
            </c:forEach>
            </tbody>
            <tbody id="searchedResult">
            	
            </tbody>
            </table>
            </div>
        </center>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HAMID</title>
</head>
<body>
<%
 String temp = (String)request.getAttribute("temp");
 String humidity = (String)request.getAttribute("humidity");
 String pressure = (String)request.getAttribute("pressure");
 String feels_like = (String)request.getAttribute("feels_like");
 String speed = (String)request.getAttribute("speed");
 String deg = (String)request.getAttribute("deg");
 String name = (String)request.getAttribute("name");
 String country = (String)request.getAttribute("country");
%>
<h1>Weather Profile</h1>

City Name 	: <%=name %><br>
Country 	: <%=country %> <br>
Temperature : <%=temp %> Kelvin <br>
Humidity 	: <%=humidity %> % <br>
Pressure 	: <%=pressure %> hPa <br>
Feels_like 	: <%=feels_like %> <br>
Wind Speed 	: <%=speed %> km/hr <br>
Degree 		: <%=deg %> <br>
</body>
</html>
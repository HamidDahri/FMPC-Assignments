<%@page import="weather.weatherprofile"%>
<%@page import="weather.weather"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
<h1> Weather Profile</h1>

<h3>City Name 		: <%=name %> </h3> 
<h3>Country 	    : <%=country %> </h3> 
<h3>Temperature 	: <%=temp %> Kelvin </h3> 
<h3>Humidity 		: <%=humidity %> % </h3> 
<h3>Pressure 		: <%=pressure %> hPa </h3> 
<h3>Feels_like 		: <%=feels_like %> </h3> 
<h3>Wind Speed 		: <%=speed %> km/hr </h3> 
<h3>Degree 			: <%=deg %> </h3> 



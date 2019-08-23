<%@include file="include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<%@include file="libStyles/libs.jsp" %>	
</head>
<body>
<%@include file="header/header.jsp" %>
	<center>Welcome ${loggedInUser}</center>
	<a href="logout">
	<button class="btn btn-lg btn-primary btn-block text-uppercase" type="button">Logout</button>
	</a>
</body>
</html>
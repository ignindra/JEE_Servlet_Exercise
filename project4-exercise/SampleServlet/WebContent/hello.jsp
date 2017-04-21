<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Student</h2>
<form action="Servlet" method="post">
	<label for="nama">Name:</label>
	<input type="text" name="nama" id="nama">
	<input type="submit" value="add">
</form>
<% int count = 1; %>
<% for (String string : (ArrayList<String>)session.getAttribute("inputs")) { %>
	<p><%= count+" "+string %></p>
	<form action="Servlet" method="get">
		<input name="deleteval" value="<%= count-1 %>" hidden>
		<input type="submit" value="remove">
	</form>
	<% count++; %>
<% } %>
</body>
</html>
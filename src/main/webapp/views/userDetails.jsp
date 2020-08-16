<%@page import="com.techpassel.springbootjpamysql.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users Details</title>
</head>
<body>
<h2>User Details</h2>
<% List<User> users = (List<User>) request.getAttribute("user");
	for(User u: users){ 
%>
<div>
	User : <%=u.getName() %>
	Password : <%=u.getPassword() %>
</div>	
<%} %>
	
</body>
</html>
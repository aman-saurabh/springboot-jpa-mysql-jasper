<%@page import="com.techpassel.springbootjpamysql.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users List</title>

</head>
<body>
<h2 style="text-align:center;">User added Successfully.</h2> 
<br><br>
<h1>Users List</h1>
<a href="http://localhost:8080/sort"><button>Sort</button></a>
</ br>
<% 
	List<User> l = (List<User>) request.getAttribute("users"); 
	for(User u: l){
%>		
	<div>
		Username : <%=u.getName() %> <a href="http://localhost:8080/details?name=<%=u.getName() %>"><button>View</button></a>
	</div>	
<% } %>
</body>
</html>
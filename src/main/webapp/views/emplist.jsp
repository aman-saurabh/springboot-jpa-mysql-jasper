<%@page import="java.util.List"%>
<%@page import="com.techpassel.springbootjpamysql.model.EmployeeDetails"%>
<%@page import="com.techpassel.springbootjpamysql.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees List</title>
</head>
<body>
<h2>Employees List</h2>
<div>
<% 
	List<Employee> elist = (List<Employee>) request.getAttribute("emplist");
	for(Employee e: elist){
	EmployeeDetails ed = e.getEmpdetails();	
%>

<div>Employee Name : <%=e.getEmpName() %></div>
<div>Employee Salary: <%=ed.getSalary() %></div><br> 
<% } %>
</div>
</body>
</html>
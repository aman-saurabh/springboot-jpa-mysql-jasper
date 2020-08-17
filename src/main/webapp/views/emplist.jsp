<%@page import="com.techpassel.springbootjpamysql.model.BlogPost"%>
<%@page import="com.techpassel.springbootjpamysql.model.Technology"%>
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
		List<Technology> eTechs = ed.getTechnologies();
		List<BlogPost> blogs = ed.getBlogpost();
%>
		<div>Employee Name : <%=e.getEmpName() %></div>
		<div>Employee Email : <%=e.getEmail() %></div>
		<div>Employee Post: <%=ed.getPost() %></div>
		<div>Employee Salary: <%=ed.getSalary() %></div>
		<div><b>Employee Technologies</b></div>
<%		
		int count = 0;
		for(Technology t: eTechs){
			count++;
			String tName = t.getTechnology();
%>
			<div><%=count %>. &nbsp;&nbsp;&nbsp;<%=tName %></div>
<% } %>
<div><b>Blog Posts of Employee</b></div>
<%		
		int blogCount = 0;
		for(BlogPost blog: blogs){
			blogCount++;
			String title = blog.getTitle();
		%>
		<div><%=blogCount %>. &nbsp;&nbsp;&nbsp; <%=title %></div>
<% } %>		
		</br>
<% } %>
</div>
</body>
</html>
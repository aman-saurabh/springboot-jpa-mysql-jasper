<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<h2>Enter User Details Here</h2>
	<form action="/add">
	<div>
		Enter Username : <input type="text" name="name">
	</div><br>
	<div>
		Enter Password : <input type="text" name="password">
	</div><br>
	<div>
		<input type="submit">
	</div>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Form</title>
</head>
<body>
<h1>Welcome to the Test Form Page!</h1>
	<form method="POST" action="TestServlet">
		First Name: <input type="text" name ="firstName"/><br> 
		Last Name: <input type="text" name ="lastName"/><br> 
		<input type="submit" name="Submit"/>
	</form>
</body>
</html>
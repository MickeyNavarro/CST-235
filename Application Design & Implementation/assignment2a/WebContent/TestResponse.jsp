<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Response</title>
</head>
<body>
	<h1>Welcome to the Test Response Page!</h1>
	The name that you have entered is: <%= request.getAttribute("firstName") %> <%= request.getAttribute("lastName") %>
</body>
</html>
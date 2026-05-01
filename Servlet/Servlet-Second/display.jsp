<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Page</title>
</head>
<body>
<h1>Details from Form</h1>
<%
    // Reading data using scriptlet tag
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String email = request.getParameter("email");
%>

<!-- Display using expression tag -->
Name: <%= name %> <br><br>
Age: <%= age %> <br><br>
Email: <%= email %> <br><br>

</body>
</html>
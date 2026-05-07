<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>JSP1</title>
</head>
<body>
<%
String name = "Nithin Gowda";
request.setAttribute("uname", name);

RequestDispatcher rd = request.getRequestDispatcher("task2jsp2.jsp");
rd.forward(request, response);
%>
</body>
</html>
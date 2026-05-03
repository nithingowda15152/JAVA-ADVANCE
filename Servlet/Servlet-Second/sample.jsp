<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WELCOME TO JSP SESSION</h1>
<!--Declaration tag:class block  -->
<%!
String name="rose";
int age=21;
public void sayHi(){
	System.out.println("hello All");
}
public int add(int a,int b){
	return a+b;
}
%>
<!--Scriplet tag:method block  -->
<%
System.out.println(name);
System.out.println(age);
double marks=90.0;
System.out.println(marks);
sayHi();
System.out.println("Sum is "+add(10,30));
%>
<!--Expression Tag: display values of variables and methods in browser  -->

<h1><%=name %>
<%=age %>
<%=marks %>
<%=add(5,10) %>
</h1>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.fooddelivery.model.* "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
User user=(User) session.getAttribute("user");
%>
<%
if(user != null){
%>
<h1>Welcome <%out.println(user.getName());%> to Home page</h1>
<%}
else {%>
<h1>User not logged in</h1>
<a href="Login.jsp">Click here to Login</a>
<%} %>
</body>
</html>
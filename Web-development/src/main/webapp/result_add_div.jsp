<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int i=Integer.parseInt(request.getParameter("f").toString());
int j=Integer.parseInt(request.getParameter("s").toString());
out.print("Sum : "+(i+j));
out.print("Division : "+(i/j));%>
</body>
</html>
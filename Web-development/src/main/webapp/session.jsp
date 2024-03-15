<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to JSP page</h1>
	<%
	session.setAttribute("userid", "SEEREE");
	%>
<a href="session_process.jsp">Link</a>
</body>
</html>
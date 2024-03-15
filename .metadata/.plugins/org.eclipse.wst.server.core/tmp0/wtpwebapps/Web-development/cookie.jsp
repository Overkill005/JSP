<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String name="SEEREE";
Cookie ck=new Cookie("uname",name);
response.addCookie(ck);
%>
<a href="cookie_process.jsp">Link</a>
</body>
</html>
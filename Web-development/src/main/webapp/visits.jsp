<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Integer visits=(Integer)application.getAttribute("k");
if(visits==null||visits==0){
	out.println("Welcome to my page");
	visits=1;
}
else{
	out.println("Welcome back to my page");
	visits++;
}
application.setAttribute("k",visits);
%>
<p>Total number of visits: <%= visits %></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Application Configuration</title>
</head>
<body>
    <% 
        application.setAttribute("name", "Sanskhhhhhar");
    %>
    <h1>Name: <%= application.getAttribute("name") %></h1>
</body>
</html>

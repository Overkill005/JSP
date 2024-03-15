<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Init Param Example</title>
</head>
<body>
    <h1>Initialization Parameter Example</h1>
    <p>Param 1: <%= getServletContext().getInitParameter("param1") %></p>
    <p>Param 2: <%= getServletContext().getInitParameter("param2") %></p>
</body>
</html>

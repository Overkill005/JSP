<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Header Example</title>
</head>
<body>
    <h2>Host: <%= request.getHeader("Host") %></h2>
    <h2>User-Agent: <%= request.getHeader("User-Agent") %></h2>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Success</title>
    <style>
        /* Your CSS styles here */
    </style>
</head>
<body>
    <h2>Order Placed Successfully!</h2>
    <p>Product Name: <%= request.getParameter("prodName") %></p>
    <p>Product Rate: <%= request.getParameter("prodRate") %></p>
    <p>Order Value: <%= request.getParameter("orderValue") %></p>
    <p>Thank you for your order!</p>
</body>
</html>

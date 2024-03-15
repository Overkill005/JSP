<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("name", "Sanskar");
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Information</title>
</head>
<body>
    <p>Name: <%= request.getAttribute("name") %></p>
</body>
</html>

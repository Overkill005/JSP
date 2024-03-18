<%@ page language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Header Values Example</title>
</head>
<body>
   
    <%
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<b>" + headerName + "</b>: " + request.getHeaders(headerName) + "<br>");
        }
    %>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
<title>PageScope Example</title>
</head>
<body>
	<%
	pageContext.setAttribute("message", "Sanskar", PageContext.PAGE_SCOPE);
	%>
	<h1>Hello <%=pageContext.getAttribute("message")%></h1>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
    <title>Processing Form</title>
</head>
<body>
    <h2>Selected Fruits:</h2>
    <ul>
        <% 
            String[] fruits = request.getParameterValues("fruit");
            if (fruits != null) {
                for (String fruit : fruits) {
        %>
        <li><%= fruit %></li>
        <%      
                }
            } else {
        %>
        <li>No fruits selected</li>
        <% 
            }
        %>
    </ul>
</body>
</html>

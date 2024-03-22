<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Leave Management System</title>
    <script type="text/javascript" src="js/jQuery.js"></script>
</head>
<body>
<%
try {
    String url = "jdbc:mysql://localhost:3306/leave_emp";
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, "root", "");
    Statement stmt = con.createStatement();
    ResultSet rs;
%>

<form method="post" action="check_leave">
    <label for="empname">Employee Name</label>
    <select name="empname" id="empname">
        <option hidden>Choose..</option>
        <%
        rs = stmt.executeQuery("select * from employee");
        while (rs.next()) {
            out.print("<option>" + rs.getString(2) + "</option>");
        }
        %>
    </select> <br>
    <label for="apply">Leave Type</label>
    <select name="apply" id="apply">
        <option hidden>Choose..</option>
        <%
        rs = stmt.executeQuery("select * from leave_master");
        while (rs.next()) {
            out.print("<option>" + rs.getString(2) + "</option>");
        }
        %>
    </select> <br>
    <label for="no_of_leave">Number of Leave Days</label>
    <input type="text" name="no_of_leave" id="no_of_leave"> <br>
    <span id="sms" style="color:red;">${param.sms }</span> <br>
    <input type="submit" value="Apply">
</form>

<table border="1" style="width: 100%; border-collapse: collapse;">
    <tr>
        <th>Employee Name</th>
        <th>Leave Type</th>
        <th>Total Leaves Taken</th>
        <th>Leaves Assigned</th>
    </tr>
    <%
    ResultSet rs1 = stmt.executeQuery("SELECT e.emp_name AS emp_name, lm.leave_name AS leave_name, SUM(la.num_of_leave) AS total_leaves_taken, lea.no_of_leave AS no_of_leaves_assigned FROM employee e CROSS JOIN leave_master lm LEFT JOIN leave_apply la ON e.emp_id = la.emp_id AND lm.leave_id = la.leave_id LEFT JOIN leave_emp_assign lea ON e.emp_id = lea.emp_id AND lm.leave_id = lea.leave_id GROUP BY e.emp_id, lm.leave_id");
    while (rs1.next()) {
        out.println("<tr>");
        out.print("<td>" + rs1.getString("emp_name") + "</td>");
        out.print("<td>" + rs1.getString("leave_name") + "</td>");
        out.print("<td>" + rs1.getString("total_leaves_taken") + "</td>");
        out.print("<td>" + rs1.getString("no_of_leaves_assigned") + "</td>");
        out.println("</tr>");
    }
    %>
</table>

<%
} catch (Exception e) {
    out.print(e.getMessage());
}
%>

<script>
function chk() {
    var no_of_leave = document.getElementById("no_of_leave").value;
    var emp_id = document.getElementById("empname").value;
    var leave_id = document.getElementById("apply").value;
    
    if (no_of_leave <= 0) {
        document.getElementById("sms").innerHTML = "Number of days cannot be negative";
        return false;
    }
    
    return true; // Submit the form if validation passes
}
</script>

</body>
</html>

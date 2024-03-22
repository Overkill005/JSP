<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD</title>
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="js/jQuery.js">

</script>
<style>
#upd, #del {
	display: none;
}
</style>
</head>
<body>
<script> 
function chk(){
	r=confirm("Are you sure ?");
	if(r){
		return true;
	}
	else{
		return false;
	}
}
</script>
	<form method="post" id="top" action="manage" onsubmit="return chk()">
	<label for="empid">Emp ID</label>
		<input name="oempid" type="hidden" value="${param.empid}" id="oempid" />
		<input name="empid" value="${param.empid}" id="empid" placeholder="Enter Employee ID"/> <br />
		<label for="empname">Emp Name</label> <input name="empname" value="${param.empname}" placeholder="Enter Employee Name"/> <br />
		<label for="salary">Salary</label> <input name="salary" value="${param.salary}" placeholder="Enter Salary"/> <br />
		 <label for="job">Job</label> <input
			name="job" value="${param.job}" placeholder="Enter Job"/> <br />
			<label for="deptno">Dept No</label> <input
			name="deptno" value="${param.deptno}" placeholder="Enter Departement No" /> <br /><div id="flex"> <input
			type="submit" value="Update" id="upd" name="btn"
			style="display:${param.fd};width:49%" /> <input type="submit" id="del"
			name="btn" value="Delete" style="display:${param.fd};width:50%;" /></div><input
			type="submit" id="ins" name="btn" value="Insert"
			style="display:${param.id};" />

	</form>
	<br />



	<h1 style="color: red;">
		Hello
		<%
String empname = request.getParameter("empname");
if (empname != null && !empname.isEmpty()) {
    out.print(empname);
} else {
    out.print("user");
}
%>!!

		 <br> ${param.sms}
	</h1>





	<br />














	<!-- -------------- --------------- -->

	<table border=1 align="center" width="90%" style="border-collapse:collapse;">
	<caption><h3>User Details</h3></caption>
		<tr>
			<th>EmpID</th>
			<th>EmpName</th>
			<th>Salary</th>
			<th>Job</th>
			<th>Dept. No</th>
			<th>Action</th>
		</tr>

		<%
		String url2 = "jdbc:mysql://localhost:3306/sdi";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url2, "root", "");
			Statement stmt = con.createStatement();
			String query = "select * from employee";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				out.print("<form action='select' method='post' >");
				out.print("<tr>");
				out.print("<td>" + rs.getInt(1) + "</td>");
				out.print("<td>" + rs.getString(2) + "</td>");
				out.print("<td>" + rs.getInt(3) + "</td>");
				out.print("<td>" + rs.getString(4) + "</td>");
				out.print("<td>" + rs.getInt(5) + "</td>");
				out.print("<td>");
				out.print("<input type='hidden' name='empid' value=" + rs.getInt(1) + " />"); 
				out.print("<input type='submit' name='btn' id='select' value='Select' style='width:100%;'>");
			
				out.print("</td>");

				out.print("</tr>");
				out.print("</form>");
			}
		} catch (Exception e) {
			out.print(e.getMessage());
		}
		%>
	</table>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.sql.*" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD</title>

</head>
<body>
	<form method="post" action="saveemp">
		Emp ID: <input name="empid" /> <br /> 
		Emp Name: <input name="empname" /> <br /> 
		Salary: <input name="salary" />
		<br /> Job: <input name="job" />
		 <br />
		 Dept no: <input name="deptno" />
		<br /> 
		<input type="submit" value="save" />
	</form>
	<br/>
	<br/>
	
<!-- Display the message which was passed from SaveEmp.java file (after successfully insert)  -->

<h1 style="color:red;">Hello, ${param.ename} ${param.sms}</h1>
<h3 style="color:blue;"> ${param.job}</h3>
	
	
	
	
<br/>
<br/>

	
<!-- ---------------------------- Display data ---------------------------- -->

<%-- <p>User Details</p>
<table border="1px" width="100%">
		<tr>
			<th>EmpID</th>
			<th>EmpNAme</th>
			<th>Salary</th>
			<th>Job</th>
			<th>Dept. No</th>
		</tr>
	
	<% 
		String url= "jdbc:mysql://localhost:3306/sdi";
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","");
			Statement stmt=con.createStatement();
			String query="select * from employee";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>"+rs.getInt(1)+"</td>");
				out.print("<td>"+rs.getString(2)+"</td>");
				out.print("<td>"+rs.getInt(3)+"</td>");
				out.print("<td>"+rs.getString(4)+"</td>");
				out.print("<td>"+rs.getInt(5)+"</td>");
				out.print("</tr>");
			}
		}
		catch(Exception e) {
			out.print(e.getMessage());
		}
		
	%>
</table> --%>

<!-- -------------------------------------------------------------------------------- -->


	
<!-- -------------- Making 2 buttons (edit and delete) in the side of the table --------------- -->



<p>User Details</p>
<table border="1px" width="100%">
		<tr>
			<th>EmpID</th>
			<th>EmpName</th>
			<th>Salary</th>
			<th>Job</th>
			<th>Dept. No</th>
			<th>Action</th>
		</tr>
	
	<% 
		String url2= "jdbc:mysql://localhost:3306/sdi";
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url2,"root","");
			Statement stmt=con.createStatement();
			String query="select * from employee";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()){
				out.print("<form action='manage' method='post' >");
				out.print("<tr>");
				out.print("<td>"+rs.getInt(1)+"</td>");
				out.print("<td>"+rs.getString(2)+"</td>");
				out.print("<td>"+rs.getInt(3)+"</td>");
				out.print("<td>"+rs.getString(4)+"</td>");
				out.print("<td>"+rs.getInt(5)+"</td>");
				out.print("<td>");
				out.print("<input type='hidden' name='empid' value="+rs.getInt(1)+" />");   
				out.print("<input type='submit' name='btn' value='Delete' />"); 
				out.print("<input type='submit' name='btn' value='Edit' />");
				out.print("</td>");	
				
				out.print("</tr>");
				out.print("</form>");
			}
		}
		catch(Exception e) {
			out.print(e.getMessage());
		}
		
	%>
</table>

	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Edit  -->

	<% 
		String url= "jdbc:mysql://localhost:3306/sdi";
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","");
			Statement stmt=con.createStatement();
			String query="select * from employee where empid="+request.getParameter("empid");
			
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()){
				out.print("<form action='update' method='post' >");
				out.print("Emp ID: "+rs.getInt(1));   // It is primary key (using this we can change everything so we can't this)
				out.print("<br/> Emp Name: <input type='text' name='empname' value='"+rs.getString(2)+"' />");
				out.print("<br/> Salary : <input type='text' name='salary' value='"+rs.getInt(3)+"' />");
				out.print("<br/> Job: <input type='text' name='job' value='"+rs.getString(4)+"' />");
				out.print("<br/> Dept No: <input type='text' name='deptno' value='"+rs.getInt(5)+"' />");
				out.print("<br/><input type='hidden' name='empid' value='"+rs.getInt(1)+"' />");
				out.print("<br/><input type='submit' name='btn' value='Update' />");
				out.print("</form>");
			}
			else{
				//response.sendRedirect("crud.jsp?sms=Problem while updating");
				//response.sendRedirect("crud.jsp?sms=Problem");
			}
		}
		catch(Exception e) {
			out.print(e.getMessage());
		}
		
	%>

</body>
</html>
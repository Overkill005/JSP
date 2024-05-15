<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD</title>
<script src="js/jQuery.js"></script>
<script>
$(document).ready(function(){
// 	alert("hi");
	$("input[type='button']").click(function(){
		tr=$(this).parents('tr');
		btn=$(this).val();
		emp_id=tr.find("#lbl_empid").html();
		if(btn=="Delete"){
			$.ajax({
				url:"deleteemp",
				type:"POST",
				dataType:"JSON",
				data:{id:emp_id},
				success:function(res){
					json_text=JSON.stringify(res);
					obj=JSON.parse(json_text);
					//alert(res);
// 					if(obj.sms=="success"){
						tr.hide();
// 					}
				}
			})
		}
		else if(btn=="Edit"){
			$(this).val("Update");
			tr.find("#lbl_empname").addClass('h');
			tr.find("#lbl_empname").removeClass('s');
			
			tr.find("#lbl_sal").addClass('h');
			tr.find("#lbl_sal").removeClass('s');
			
			tr.find("#lbl_job").addClass('h');
			tr.find("#lbl_job").removeClass('s');
			
			tr.find("#lbl_deptno").addClass('h');
			tr.find("#lbl_deptno").removeClass('s');
			
			tr.find("#txt_empname").addClass('s');
			tr.find("#txt_empname").removeClass('h');
			
			tr.find("#txt_sal").addClass('s');
			tr.find("#txt_sal").removeClass('h');
			
			tr.find("#txt_job").addClass('s');
			tr.find("#txt_job").removeClass('h');
			
			tr.find("#txt_deptno").addClass('s');
			tr.find("#txt_deptno").removeClass('h');
		}
		else if(btn=="Update"){
			$(this).val("Edit");
			emp_name=tr.find("#txt_empname").val();
			emp_sal=tr.find("#txt_sal").val();
			emp_job=tr.find("#txt_job").val();
			emp_deptno=tr.find("#txt_deptno").val();
			$.ajax({
				url:"updateemp",
				type:"POST",
				dataType:"json",
				data:{id:emp_id,sal:emp_sal,name:emp_name,job:emp_job,deptno:emp_deptno},
				success:function(res){
					json_text=JSON.stringify(res);
					obj=JSON.parse(json_text);
					alert(res);
					if(obj.sms=="success"){
						location.reload();
					}
					
				}
			})
		}
		
	})
})


</script>
<style>
.h{
	display:none;
}
.s{
	display:block;
}
</style>
</head>
<body>



	<table border=1 align="center" width="90%" style="border-collapse: collapse;">
		<caption>
			<h3>User Details</h3>
		</caption>
		<tr>
			<th>EmpID</th>
			<th>EmpName</th>
			<th>Salary</th>
			<th>Job</th>
			<th>Dept. No</th>
			<th>Action</th>
		</tr>

		<%

		try {
		String url = "jdbc:mysql://localhost:3306/sdi";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			String query = "select * from employee";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				out.print("<tr>");
				out.print("<td><label for='empid' id='lbl_empid'>" + rs.getInt(1)+ "</label></td>");
						
				out.print("<td><label id='lbl_empname' class='s'>" + rs.getString(2)+ "</label>");
				out.print("<input type='text' id='txt_empname' class='h' value='" + rs.getString(2) + "'></td>");
						
				out.print("<td><label id='lbl_sal' class='s'>" + rs.getInt(3)+ "</label>");
				out.print("<input type='text' id='txt_sal' class='h' value='" + rs.getInt(3) + "'></td>");
						
				out.print("<td><label id='lbl_job' class='s'>" + rs.getString(4)+ "</label>");
				out.print("<input type='text' id='txt_job' class='h' value='" + rs.getString(4) + "'></td>");
						
				out.print("<td><label id='lbl_deptno' class='s'>" + rs.getInt(5)+ "</label>");
				out.print("<input type='text' id='txt_deptno' class='h' value='" + rs.getInt(5) + "'></td>");
						
				out.print("<td>");
				out.print("<input type='button' value='Edit' style='width:50%;' />");
				out.print("<input type='button' value='Delete' style='width:50%;'>");
				out.print("</td>");

				out.print("</tr>");
			}
		} catch (Exception e) {
			out.print(e.getMessage());
		}
		%>
	</table>
</body>
</html>
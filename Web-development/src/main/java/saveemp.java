import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/saveemp")
public class saveemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String empid=request.getParameter("empid");
		String empname=request.getParameter("empname");
		String salary=request.getParameter("salary");
		String job=request.getParameter("job");
		String deptno=request.getParameter("deptno");
		String url= "jdbc:mysql://localhost:3306/sdi";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","");
			Statement stmt=con.createStatement();
			String query="INSERT INTO employee values("+empid+",'"+empname+"',"+salary+",'"+job+"',"+deptno+")";
			// we can give single quote '' to all variables also (no error)
			//String query="INSERT INTO employee values('"+empid+"','"+empname+"','"+salary+"','"+job+"','"+deptno+"')";
			
			stmt.execute(query);
			out.print("1 Record inserted");
	
			response.sendRedirect("crud.jsp?ename="+empname+"&sms=You Register successfully!&job="+job); // passing sms and job name through url
			// note inside the double quote "" whatever name declare like ename (that we have to write in ${param.ename}
			
		}
		catch(Exception e) {
			out.print(e.getMessage());
		}
	}

}
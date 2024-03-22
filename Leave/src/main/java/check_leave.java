
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class check_leave
 */
@WebServlet("/check_leave")
public class check_leave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public check_leave() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out = response.getWriter();
		String empname = request.getParameter("empname");
		String leavename = request.getParameter("apply");
		String odays = request.getParameter("no_of_leave");
		try {

			String url = "jdbc:mysql://localhost:3306/leave_emp";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt1=con.createStatement();
			
			
			
			  String checkLeaveQuery = "select * from leave_emp_assign where emp_id= (select emp_id from employee where emp_name='"+ empname + "') and leave_id= (select leave_id from leave_master where leave_name='"+ leavename +"')";
	            stmt1 = con.createStatement();
	            
	            ResultSet rs = stmt1.executeQuery(checkLeaveQuery);
	            while(rs.next()) {
	                int availableLeave = rs.getInt("no_of_leave");
	                if (Integer.parseInt(odays) <= availableLeave &&Integer.parseInt(odays)>0){
	                	
	               	stmt1.executeUpdate("UPDATE leave_emp_assign SET no_of_leave = " + (  Integer.parseInt(rs.getString(4))-Integer.parseInt(odays)) + " WHERE emp_id = (SELECT emp_id FROM employee WHERE emp_name = '" + empname + "') AND leave_id = (SELECT leave_id FROM leave_master WHERE leave_name = '" + leavename + "')");
	                	stmt1.executeUpdate("insert into leave_apply (emp_id,leave_id,num_of_leave)values((select emp_id from employee where emp_name='"+ empname + "'),(select leave_id from leave_master where leave_name='" + leavename + "'),"+ odays + ")");
	                	response.sendRedirect("leave_apply.jsp?sms=Leave application submitted");
	                }
	                	else {
	                		response.sendRedirect("leave_apply.jsp?sms=Not valid");
	                		
	                	}
	            }
	                
			
//			ResultSet rs2=stmt1.executeQuery("select * from leave_emp_assign where emp_id= (select emp_id from employee where emp_name='"+ empname + "') and leave_id= (select leave_id from leave_master where leave_name='"+ leavename + "')");
		

		
		} catch (Exception e) {
			out.println(e.getMessage());
		}

	}

}

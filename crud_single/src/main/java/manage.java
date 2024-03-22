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

@WebServlet("/manage")
public class manage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String oempid = request.getParameter("oempid");
		String empid = request.getParameter("empid");
		String empname = request.getParameter("empname");
		String salary = request.getParameter("salary");
		String job = request.getParameter("job");
		String deptno = request.getParameter("deptno");
		String btn = request.getParameter("btn");

		String url = "jdbc:mysql://localhost:3306/sdi";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();

			if (btn.equals("Delete")) {
				String query = "DELETE FROM employee where empid=" + empid;
				int ups = stmt.executeUpdate(query);
//				if(ups>0) {
				response.sendRedirect("crud.jsp?sms=" + ups + " Record(s) successfully deleted");
//				}
//				else { 
//					 out.print("crud.jsp?sms=Error while deleting");
//				}

			} else if (btn.equals("Update")) {
				if (oempid.equals(empid)) {
					String query1 = "UPDATE employee set empname='" + empname + "', salary=" + salary + ", job='" + job
							+ "', deptno='" + deptno + "' where empid=" + empid;
					int ups1 = stmt.executeUpdate(query1);
					response.sendRedirect("crud.jsp?sms=" + ups1 + " Record(s) updated successfully");
				} else {
					response.sendRedirect("crud.jsp?sms=EmpID cannot be updated (primary key)");
				}

			} else if (btn.equals("Insert")) {
				String query2 = "INSERT INTO employee values(" + empid + ",'" + empname + "'," + salary + ",'" + job
						+ "'," + deptno + ")";
				ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE empid=" + empid);

				// Check if the primary key already exists
				if (rs.next()) {
					response.sendRedirect("crud.jsp?sms=EmpID already exists (primary key)");
				} else {

					stmt.executeUpdate(query2);
					response.sendRedirect("crud.jsp?sms=1 Record inserted successfully");
				}

			} else {

				response.sendRedirect("crud.jsp?sms=Error while fetching data");
			}

		} catch (

		Exception e) {
			out.print(e.getMessage());
		}
	}

}
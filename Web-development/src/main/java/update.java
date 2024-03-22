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

@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

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

			String query = "UPDATE employee set empname='" + empname + "', salary=" + salary + ", job='" + job
					+ "', deptno='" + deptno + "' where empid=" + empid;
			stmt.executeUpdate(query);
			response.sendRedirect("crud.jsp?sms=updated successfully");
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
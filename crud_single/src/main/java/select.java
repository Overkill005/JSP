
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
 * Servlet implementation class select
 */
@WebServlet("/select")
public class select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public select() {
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
		String empid = request.getParameter("empid");
//		String empname = request.getParameter("empname");
//		String salary = request.getParameter("salary");
//		String job = request.getParameter("job");
//		String deptno = request.getParameter("deptno");
		String url = "jdbc:mysql://localhost:3306/sdi";

		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			String que = "select * from employee where empid=" + empid;
			ResultSet rs = stmt.executeQuery(que);
			out.println("console.log(" + empid + ")");
			if (rs.next()) {

				response.sendRedirect(
						"crud.jsp?empid=" + empid + "&empname=" + rs.getString(2) + "&salary=" + rs.getString(3)
								+ "&job=" + rs.getString(4) + "&deptno=" + rs.getString(5) + "&fd=inline&id=none");
			} else {
//				<h1 style="color: red;">Hello, ${param.ename} ${param.sms}</h1>
			}
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}

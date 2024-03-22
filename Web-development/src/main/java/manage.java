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

@WebServlet("/manage")
public class manage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String empid = request.getParameter("empid");
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
				response.sendRedirect("crud.jsp?sms=successfully deleted");
//				}
//				else { 
//					 out.print("crud.jsp?sms=Error while deleting");
//				}

			} else if (btn.equals("Edit")) {
				response.sendRedirect("edit.jsp?empid=" + empid);
//				response.sendRedirect("edit.jsp");
			} else {
				response.sendRedirect("crud.jsp?smd=deleting problem");
			}

		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
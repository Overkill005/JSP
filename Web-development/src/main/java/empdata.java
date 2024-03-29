import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class empdata
 */
@WebServlet("/empdata")
public class empdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public empdata() {
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
		PrintWriter out = response.getWriter();
		int num_of_col;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdi");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			ResultSetMetaData rsmd = rs.getMetaData();
			JSONArray jarr = new JSONArray();
			while (rs.next()) {
				JSONObject obj = new JSONObject();
				num_of_col = rsmd.getColumnCount();
				for (int i = 1; i <= num_of_col; i++) {
					String col = rsmd.getColumnName(i);
					obj.put(col, rs.getObject(i));
				}
				jarr.put(obj);

			}
			out.print(jarr);
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}
}

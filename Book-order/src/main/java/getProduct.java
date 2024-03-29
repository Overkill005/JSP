
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class getProduct
 */
@WebServlet("/getproduct")
public class getProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getProduct() {
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

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/order_book";
			Connection con = DriverManager.getConnection(url, "root", "");

			PreparedStatement stmt = con.prepareStatement(
					"select * from product_master where prodname='" + request.getParameter("prodname") + "'");
			ResultSet rs = stmt.executeQuery();
			JSONArray jarr = new JSONArray();
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				int col = rsmd.getColumnCount();
				JSONObject obj = new JSONObject();
				for (int i = 1; i <= col; i++) {
					String colname = rsmd.getColumnName(i);
					obj.put(colname, rs.getObject(i));

				}
				jarr.put(obj);
			}
			out.print(jarr);
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}

}

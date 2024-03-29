import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String productName = request.getParameter("productName");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		// Database connection parameters
		String url = "jdbc:mysql://localhost:3306/sdi";
		String username = "root";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// Establish database connection
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, "");

			// Query to retrieve product details
			String selectSql = "SELECT ProdID, ProdRate, ProdQty FROM Product_Master WHERE ProdName = ?";
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setString(1, productName);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int prodId = rs.getInt("ProdID");
				double rate = rs.getDouble("ProdRate");
				int availableQty = rs.getInt("ProdQty");

				if (quantity <= availableQty) {
					// Calculate order value
					double orderValue = rate * quantity;

					// Insert order into Order_Master table
					String insertSql = "INSERT INTO Order_Master (ProdID, ProdRate, OrderQty, OrderValue) VALUES (?, ?, ?, ?)";
					pstmt = conn.prepareStatement(insertSql);
					pstmt.setInt(1, prodId);
					pstmt.setDouble(2, rate);
					pstmt.setInt(3, quantity);
					pstmt.setDouble(4, orderValue);
					pstmt.executeUpdate();

					// Update Product_Master table with reduced quantity
					String updateSql = "UPDATE Product_Master SET ProdQty = ? WHERE ProdID = ?";
					pstmt = conn.prepareStatement(updateSql);
					pstmt.setInt(1, availableQty - quantity);
					pstmt.setInt(2, prodId);
					pstmt.executeUpdate();

					out.println("Order placed successfully! Order value: $" + orderValue);
				} else {
					out.println("Error: Quantity exceeds available quantity for " + productName);
				}
			} else {
				out.println("Error: Product not found in database");
			}
		} catch (Exception e) {
			out.println("Error: " + e.getMessage());
		} finally {
			try {
				// Close resources
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				out.println("Error: " + e.getMessage());
			}
		}
	}
}

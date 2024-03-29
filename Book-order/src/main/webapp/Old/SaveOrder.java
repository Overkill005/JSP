
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveOrder")
public class SaveOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//        response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int prodID = Integer.parseInt(request.getParameter("prodID"));
		int orderQty = Integer.parseInt(request.getParameter("orderQty"));
		double orderValue = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdi", "root", "");

			// Get product rate
			PreparedStatement psRate = con
					.prepareStatement("SELECT ProdRate, ProdQty, ProdName FROM Product_Master WHERE ProdID=?");
			psRate.setInt(1, prodID);
			ResultSet rsRate = psRate.executeQuery();

			if (rsRate.next()) {
				double prodRate = rsRate.getDouble("ProdRate");
				int availableQty = rsRate.getInt("ProdQty");
				String prodName = rsRate.getString("ProdName");

				if (availableQty >= orderQty) {
					orderValue = prodRate * orderQty;

					// Redirect to another page with order details
					if (orderQty == 0) {
						out.println("Invalid input, cannot be 0");

					} else {
						// Insert order into Order_Master table

						PreparedStatement psInsert = con.prepareStatement(
								"INSERT INTO Order_Master (OrderDate, ProdID, OrderQty, OrderValue, ProdRate) VALUES (CURDATE(), ?, ?, ?, ?)");
						psInsert.setInt(1, prodID);
						psInsert.setInt(2, orderQty);
						psInsert.setDouble(3, orderValue);
						psInsert.setDouble(4, prodRate);
						int rowsAffected = psInsert.executeUpdate();

						if (rowsAffected > 0) {
							// Update product quantity in Product_Master table
							PreparedStatement psUpdate = con.prepareStatement(
									"UPDATE Product_Master SET ProdQty = ProdQty - ? WHERE ProdID = ?");
							psUpdate.setInt(1, orderQty);
							psUpdate.setInt(2, prodID);
							psUpdate.executeUpdate();
							response.sendRedirect("orderSuccess.jsp?prodName=" + prodName + "&prodRate=" + prodRate
									+ "&orderValue=" + orderValue);
						} else {
							out.println("Failed to place order.");
						}
					}
				} else {
					out.println("Not enough quantity available for this product.");
				}
			} else {
				out.println("Product not found!");
			}
			con.close();
		} catch (Exception e) {
			out.println(e);
		}
	}
}

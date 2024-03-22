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

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String productName = request.getParameter("productName");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdi", "root", "");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM Product_Master WHERE ProdName=?");
			ps.setString(1, productName);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int prodID = rs.getInt("ProdID");
				double prodRate = rs.getDouble("ProdRate");
				int prodQty = rs.getInt("ProdQty");
				out.println("<p>Product ID: " + prodID + "</p>");
				out.println("<p>Product Rate: " + prodRate + "</p>");
				out.println("<p>Available Quantity: " + prodQty + "</p>");
				out.println("<label for='orderQty'>Order Quantity:</label>");
				out.println("<input type='number' id='orderQty' name='orderQty' min='1' max='" + prodQty + "'>");
				out.println("<button id='submitOrder'>Submit Order</button>");
				out.println("<script>");
				out.println("$('#submitOrder').click(function(){");
				out.println("var qty = $('#orderQty').val();");
				out.println("$.ajax({");
				out.println("url: 'SaveOrder',");
				out.println("type: 'POST',");
				out.println("data: {prodID: " + prodID + ", orderQty: qty},");
				out.println("success: function(response){");
				out.println("document.getElementById('invalidp').innerHTML=response;");
				// out.println("response");
//                out.println(");");
				out.println("}");
				out.println("});");
				out.println("});");
				out.println("</script>");
			} else {
				out.println("<p>Product not found!</p>");
			}

			con.close();
		} catch (Exception e) {
			out.println(e);
		}
	}
}

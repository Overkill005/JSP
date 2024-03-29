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

@WebServlet("/createorder")
public class createorder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		String prodid = request.getParameter("prodid");
		String prodname = request.getParameter("prodname");
		int prodqty = Integer.parseInt(request.getParameter("prodqty"));
		int oprodqty = Integer.parseInt(request.getParameter("oprodqty"));
		int prodrate = Integer.parseInt(request.getParameter("prodrate"));
		int ordervalue = prodrate * prodqty;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/order_book";
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into order_master (prodid,prodrate,orderqty,ordervalue) values( " + prodid + ","
					+ prodrate + "," + prodqty + "," + ordervalue + ")");
			stmt.executeUpdate("update product_master set prodqty=" + (oprodqty - prodqty) + " where prodid=" + prodid);
			out.println("<head><link rel='stylesheet' href='css/style_create.css'></head>");

			out.println("<video id=\"bg\" src=\"./media/bgvideo.mp4\" autoplay loop muted></video></div>");
			out.println("<div class='bill'>");
			out.println("<h1>Order placed successfully!</h1>");
			out.println("<h2>Order Details:</h2>");
			out.println("<h3><span id='heading'> Product Name: </span>" + prodname + "</h3>");
			out.println("<h3><span id='heading'> Product ID: </span>" + prodid + "</h3>");
			out.println("<h3><span id='heading'> Quantity: </span>" + prodqty + "</h3>");
			out.println("<h3><span id='heading'> Order Value: </span>" + ordervalue + "</h3>");
			out.println("</div>");

		} catch (Exception e) {

			out.print(e.getMessage());
		}
	}

}
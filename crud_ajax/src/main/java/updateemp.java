

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


@WebServlet("/updateemp")
public class updateemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateemp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out=response.getWriter();
		try {
		String empid=request.getParameter("id");
		String empname=request.getParameter("name");
		String salary=request.getParameter("sal");
		String job=request.getParameter("job");
		String deptno=request.getParameter("deptno");
		String url = "jdbc:mysql://localhost:3306/sdi";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "root", "");
		Statement stmt = con.createStatement();
		String sql = "update employee set empname='"+empname+"',salary="+salary+", job='"+job+"',deptno="+deptno+" where empid="+empid;
		stmt.executeUpdate(sql);

		out.print("{ \"sms\":\"success\" }");
		}
		catch(Exception e){
			out.print(e.getMessage());
		}
	}

}

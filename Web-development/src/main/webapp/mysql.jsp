
<%@ page import="java.sql.*"%>
<%
try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdi", "root", "");
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from student");
	while (rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		out.println(id + " &emsp;" + name + "<br>");

	}
} catch (Exception e) {
	out.print(e.getMessage());
}
%>

package ghas.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class Test extends HttpServlet {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean success = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// Unsafe query which uses string concatenation
		String query = "select * from tbluser where username='" + username + "' and password = '" + password + "'";
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/user", "root", "root");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				// Login Successful if match is found
				success = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		if (success) {
			response.sendRedirect("home.html");
		} else {
			response.sendRedirect("login.html?error=1");
		}
	}
}
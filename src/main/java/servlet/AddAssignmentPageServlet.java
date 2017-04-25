package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;

public class AddAssignmentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLoginManager LoginManager = UserLoginManager.getInstance();
       
    public AddAssignmentPageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection conn = null;
		String url="jdbc:mysql://localhost:3306/";
		String dbName = "kanwas";
		String driver="com.mysql.jdbc.Driver";
		String unicode = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		String urlPattern = "jdbc:mysql://%s:%s/%s";
		String connectionURL = String.format(urlPattern, "localhost", "3306", "kanwas");

		try {

			String title = request.getParameter("title");
			String content = request.getParameter("submit-text");
			String points = request.getParameter("points");


			Class.forName(driver).newInstance();
			System.out.println("csatlakozás...");

			conn = DriverManager.getConnection(url+dbName+unicode, "root", "ezer990");

			System.out.println("csatlakozás ok");
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("INSERT INTO `kanwas`.`assignments`(`Title`,`Content`,`MaxScore`) VALUES(?,?,?)");

			ps.setString(1,title);
			ps.setString(2,content);
			ps.setString(3,points);

			ps.execute();

			ps.close();

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

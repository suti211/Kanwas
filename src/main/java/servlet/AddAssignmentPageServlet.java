package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import module.Assignment;
import module.Module;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class AddAssignmentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLoginManager LoginManager = UserLoginManager.getInstance();
       
    public AddAssignmentPageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post hívás");
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

			String jsonString = request.getParameter("json");
			System.out.println(jsonString);
			Assignment m = new Gson().fromJson(jsonString, Assignment.class);
			System.out.println(m);

			Class.forName(driver).newInstance();
			System.out.println("csatlakozás...");

			conn = DriverManager.getConnection(url+dbName+unicode, "root", "ezer990");

			System.out.println("csatlakozás ok");
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("INSERT INTO `kanwas`.`assignments`(`Title`,`Content`,`MaxScore`,`Published`) VALUES(?,?,?,?)");

			ps.setString(1,m.getTitle());
			ps.setString(2,m.getContent());
			ps.setInt(3,m.getMaxScore());
			ps.setBoolean(4, m.isPublished());

			ps.execute();

			ps.close();

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

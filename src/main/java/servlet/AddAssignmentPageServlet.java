package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.SQLConnector;
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




		try {
			SQLConnector sqlConnector = new SQLConnector();

			String jsonString = request.getParameter("json");
			System.out.println(jsonString);
			Assignment m = new Gson().fromJson(jsonString, Assignment.class);
			System.out.println(m);

			System.out.println("csatlakozás...");


			System.out.println("csatlakozás ok");
			sqlConnector.sendQuery("INSERT INTO `kanwas`.`modules`(`Title`,`Content`,`MaxScore`,`Published`) VALUES(" +"'"+ m.getTitle()+"'"+","+"'"+ m.getContent()+"'"+","+ "'"+m.getMaxScore()+"'"+","+"'"+m.isPublished()+"'"+")");
			sqlConnector.sendQuery("SET SQL_SAFE_UPDATES = 0;" );
			sqlConnector.sendQuery("UPDATE modules SET IndexID = id WHERE IndexID is null and id is not null");

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
//SET SQL_SAFE_UPDATES = 0;
	//	"UPDATE modules SET IndexID = id WHERE IndexID is null and id is not null"
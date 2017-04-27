package servlet;

import com.google.gson.Gson;
import com.mysql.cj.api.Session;
import io.SQLConnector;
import module.Assignment;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tamás Ferenc on 2017. 04. 26..
 */
@WebServlet(name = "AddAnswerServlet")
public class AddAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            SQLConnector sqlConnector = new SQLConnector();

            String jsonString = request.getParameter("json");
            System.out.println(jsonString);
            Assignment m = new Gson().fromJson(jsonString, Assignment.class);
            System.out.println(m);


            String answer = request.getParameter("modalarea");
            System.out.println(answer);
            System.out.println("csatlakozás...");
            HttpSession session = request.getSession(false);
            User u =(User) session.getAttribute("user");
            System.out.println("csatlakozás ok");
            sqlConnector.sendQuery("INSERT INTO `kanwas`.`answers`(`Author`,`Content`,`Published`) VALUES(" +"'"+ u.getFullName()+"'"+","+"'"+ request.getParameter("txt1")+"'"+","+ "'"+m.isPublished()+"'"+")");
            sqlConnector.sendQuery("SET SQL_SAFE_UPDATES = 0;" );
            sqlConnector.sendQuery("UPDATE modules SET IndexID = id WHERE IndexID is null and id is not null");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

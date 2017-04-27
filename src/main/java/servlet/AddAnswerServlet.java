package servlet;

import com.google.gson.Gson;
import com.mysql.cj.api.Session;
import io.SQLConnector;
import module.Module;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tamás Ferenc on 2017. 04. 26..
 */
public class AddAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        User u =(User) session.getAttribute("user");
        SQLConnector sqlConnector = new SQLConnector();
        ResultSet rs = sqlConnector.getData("SELECT * FROM kanwas.users;");
        int id = 0;
        try {
            while (rs.next()) {
                if (rs.getString("Email").equals(u.getEmailAddress())) {
                    id = rs.getInt("id");
                }

                //String jsonString = request.getParameter("json");
                //Module m = new Gson().fromJson(jsonString, Module.class);
                System.out.println(id);
                System.out.println("csatlakozás...");

                System.out.println("csatlakozás ok");
                System.out.println(u.getFullName());
                System.out.println(request.getParameter("txt1"));
                sqlConnector.sendQuery("INSERT INTO `kanwas`.`answers`(`Author`,`Content`) VALUES(" + "'" +id + "'"+","+"'" +request.getParameter("txt1") + "'" + ")");
                sqlConnector.sendQuery("SET SQL_SAFE_UPDATES = 0;");
                sqlConnector.sendQuery("UPDATE modules SET IndexID = id WHERE IndexID is null and id is not null");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

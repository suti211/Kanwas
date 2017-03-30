package servlet;

import data.Data;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tamasferenc on 2017.03.29..
 */
public class LoginServlet extends HttpServlet
{
    String email;
    String password;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email = request.getParameter("email");
        password = request.getParameter("pass");
        Data users = Data.newInstance();

        if (email.equals("") || password.equals(""))
        {
            request.setAttribute("message", "<div class=\"error\"> ERROR: Requested field is empty.  </div>");
        }

        for (User user: users.getUserList())
        {
            if(user.getEmailAddress().equals(email))
            {
                if(user.getPassword().equals(password))
                {
                    //users.setCurrentUser(user);
                    request.setAttribute("message", "<div class=\"success\"> SUCCESS: You logged in, nigga.  </div>");
                }
                else
                {
                    request.setAttribute("message", "<div class=\"error\"> ERROR: E-mail or password is incorrect. </div>");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

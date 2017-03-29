package servlet;

import data.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tamasferenc on 2017.03.29..
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    String firstname;
    String lastname;
    String email;
    String password;
    String role;
    String name;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        firstname = request.getParameter("first-name");
        lastname = request.getParameter("last-name");
        name = firstname + lastname;
        email = request.getParameter("e_mail");
        if(request.getParameter("pass").equals(request.getParameter("pass2")))
        {
            password=request.getParameter("pass");
        }
        else
        {
            notValidPassword();
        }
        role = request.getParameter("rule");

        Data data = Data.newInstance();
        data.addUser(role, name, email, password);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void notValidPassword()
    {

    }
}

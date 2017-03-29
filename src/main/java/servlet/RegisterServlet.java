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
        
        //TODO: Remove dis
        System.out.println(request.getParameter("pass"));
        
        if(request.getParameter("pass").equals(request.getParameter("pass2")))
        {     	
            password=request.getParameter("pass");
        }
        else
        {
            notValidPassword(request, response);
        }
        role = request.getParameter("rule");

        Data data = Data.newInstance();
        //data.addUser(role, name, email,"", password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	System.out.println("!! GET !!");
    	request.setAttribute("message", "SAJT");
    	
    }
    protected void notValidPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("message", "<div class=\"error\"> ERROR: Apadfasza adj jelszót </div>");
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}

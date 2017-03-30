package servlet;

import static data.Encrypt.encrypt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Data;
import user.User;

/**
 * Created by tamasferenc on 2017.03.29..
 */
public class LoginServlet extends HttpServlet
{
    String email;
    String pass;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email = request.getParameter("email");
        pass = request.getParameter("pass");
        Data users = Data.newInstance();

        if (email.equals("") || pass.equals(""))
        {
            request.setAttribute("message", "<div class=\"error\"> ERROR: Requested field is empty.  </div>");
        }

        
        boolean emailFound = false;
        for (User user: users.getUserList())
        {      	
            if(user.getEmailAddress().equals(email))
            {
            	emailFound = true;
            	
            	//Encrypt pass
            	try {
        	        pass = encrypt(pass);
        			
        			System.out.println("re-generated password: " + pass);
        			
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
            	
            	
            	//Password incorrect
                if(user.getPassword().equals(pass))
                {
                    //users.setCurrentUser(user);
                    request.setAttribute("message", "<div class=\"success\"> SUCCESS: You logged in, nigga.  </div>");
                    users.putToMap(user, users.stringGenerator());
                    System.out.println("Succesful authentication: " + email);
                    
                    Cookie cookie = new Cookie("sessionID", users.getSessions().get(user));
                    cookie.setMaxAge(3*(60 * 60));
                    //cookie.setDomain("/");
                    response.addCookie(cookie);
                }
                else
                {
                    request.setAttribute("message", "<div class=\"error\"> ERROR: E-mail or password is incorrect. </div>");
                }
                
            }
        }
        
        // E-mail not found
        if (emailFound == false)
        {
        	request.setAttribute("message", "<div class=\"error\"> ERROR: E-mail or password is incorrect. </div>");
        }
        
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    
    
    //TODO: Implement
	private String getCookie(HttpServletRequest request)
	{	
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		{
			for (int i = 0; i < cookies.length; i++)
			{
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("sessionID"))
				{	
					return cookie.getValue(); 
				}        	
			}
			return "";
		}
		return "";
	}
}

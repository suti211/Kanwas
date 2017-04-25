package servlet;

import static data.Encrypt.encrypt;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Data;
import io.SQLConnector;
import user.User;

public class LoginServlet extends HttpServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SQLConnector sqlConnector = new SQLConnector();
	
	String email;
    String pass;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        email = request.getParameter("email");
        pass = request.getParameter("pass");
        Data users = Data.newInstance();
		
        //Redirect user if already logged in
        User currentUser = (User) request.getSession(false).getAttribute("user");
		if (currentUser != null)
		{
			response.sendRedirect("./profile");
			return;
		}

		//Emmail compare
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
            	
            	
            	/*
            	 * SQL Get password
            	 */
            	ResultSet rs = sqlConnector.getData("SELECT password FROM users WHERE email = '" + email + "'");
            	String passwordFromDB = "";
    			
            	try {
            		
            		passwordFromDB = null;
            		
					if( rs.next() )
					{
						passwordFromDB = rs.getString(1);
					}
				} catch (SQLException e) {
					System.out.println("Error @ LoginServlet: Get password from DB");
					e.printStackTrace();
				}
            	
            	//Password incorrect
                if(passwordFromDB.equals(pass))
                {
                    //users.setCurrentUser(user);
                    request.setAttribute("message", "<div class=\"success\"> SUCCESS: You logged in, nigga.  </div>");
                    
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user", user);
                    
                    
                    response.sendRedirect("./profile?first=yes");
                    return;
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
        
        doGet(request,response);
        //request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Data d = Data.newInstance();
    	
    	User currentUser = null;
    	HttpSession session = request.getSession(false);
    	
    	if(session != null){
    		currentUser = (User) request.getSession(false).getAttribute("user");
    	}
    	
		if (currentUser == null)
		{
			request.setAttribute("extramenu", "Click here to log in.");
			request.setAttribute("extraurl", "./login");
		}else{
			request.setAttribute("extramenu", currentUser.getFirstName());
			request.setAttribute("extraurl", "./profile");
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

}

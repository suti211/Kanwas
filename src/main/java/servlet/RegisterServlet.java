package servlet;

import static data.Encrypt.encrypt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Data;
import io.SQLConnector;
import user.User;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String firstName = "";
    String lastName = "";
    String email = "";
    String role = "";
    String fullName = "";
    String pass = "";
    String pass2 = "";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        firstName = request.getParameter("first-name");
        lastName = request.getParameter("last-name");
        fullName = firstName + " " + lastName;
        email = request.getParameter("email");
        pass = request.getParameter("pass");
        pass2 = request.getParameter("pass2");
        role = request.getParameter("role");
        
        Data data = Data.newInstance();
        User currentUser = (User)request.getSession(false).getAttribute("user");
//        User currentUser = data.getCurrentUser(data.getCookie(request));
		if (currentUser == null)
		{
			request.setAttribute("extramenu", "Click here to log in.");
			request.setAttribute("extraurl", "./login");
		}else{
			request.setAttribute("extramenu", currentUser.getFirstName());
			request.setAttribute("extraurl", "./profile");
		}
        
		
		//Weak password
        if (pass.length() < 6)
        {
        	request.setAttribute("message", "<div class=\"error\"> ERROR: Password is too weak (at least 6 characters).  </div>");
        	request.getRequestDispatcher("/register.jsp").forward(request, response);
        	return;
        }  
        
        //Password does not match
        if(pass.equals(pass2))
        {     
            //Convert password
			pass = encrypt(pass);
			pass2 = "";
    			
            System.out.println("Password encrypted: " + pass);
        }
        else
        {
        	request.setAttribute("message", "<div class=\"error\"> ERROR: Password does not match. </div>");
        	request.getRequestDispatcher("/register.jsp").forward(request, response);
        	return;
        }
        
        //Empty fields
        if (firstName.equals("") || lastName.equals("") || email.equals("") || role.equals(""))
        {
        	request.setAttribute("message", "<div class=\"error\"> ERROR: Requested field is empty.  </div>");
        	request.getRequestDispatcher("/register.jsp").forward(request, response);
        	return;
        }     
        
        System.out.println("email: " + email);
        
        
        boolean alreadyExist = false;
        System.out.println(data.getUserList().size());

        for(User u: data.getUserList()){
        	if(u.getEmailAddress().equals(email)){
        		alreadyExist = true;
        	}
        }
        
        if(!alreadyExist){
        	//data.addUser(role, firstName, lastName, email, pass);
        	
        	/*
        	 * SQL : START
        	 */
        	SQLConnector sqlConnector = new SQLConnector();
        	sqlConnector.sendQuery("INSERT INTO users VALUES ('0', '" + email + "', '" + pass + "', '" + firstName + "', '"+ lastName +"', '" + role + "');");
        	
        	/*
        	 * SQL : END
        	 */
        	
        	request.setAttribute("message", "<div class=\"success\"> SUCCESS: You succesfully created an account.  </div>");
        } else {
        	request.setAttribute("message", "<div class=\"error\"> ERROR: E-mail address already registered  </div>");
        }
        
        request.getRequestDispatcher("/register.jsp").forward(request, response);
        //doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		request.getRequestDispatcher("/register.jsp").forward(request, response);
    	
    }
    

}
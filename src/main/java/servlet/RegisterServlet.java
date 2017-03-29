package servlet;

import data.Data;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tamasferenc on 2017.03.29..
 */
public class RegisterServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String firstName = "";
    String lastName = "";
    String email = "";
    String role = "";
    String name = "";
    String pass = "";
    String pass2 = "";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        firstName = request.getParameter("first-name");
        lastName = request.getParameter("last-name");
        //name = firstName + " " + lastName;
        email = request.getParameter("email");
        pass = request.getParameter("pass");
        pass2 = request.getParameter("pass2");
        role = request.getParameter("role");
        
        
        //TODO: Remove dis
        System.out.println(request.getParameter("pass"));
        
        //Password does not match
        if(pass.equals(pass2))
        {     
            //Convert password
    		try {
    	        byte[] bytesOfPassword = pass.getBytes("UTF-8");
    	        MessageDigest md;
    			
    			md = MessageDigest.getInstance("MD5");
    			byte[] md5Password = md.digest(bytesOfPassword);
    			pass = md5Password.toString();
    			pass2 = "";
    			
    			System.out.println(pass);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	
            System.out.println("Success! :)");
        }
        else
        {
        	request.setAttribute("message", "<div class=\"error\"> ERROR: Password does not match. </div>");
        }
        
        //Empty fields
        if (firstName.equals("") || lastName.equals("") || email.equals("") || role.equals(""))
        {
        	request.setAttribute("message", "<div class=\"error\"> ERROR: Requested field is empty.  </div>");
        }
       

        Data data = Data.newInstance();
        
        for (User u: data.getUserList())
        {
            if(u.getEmailAddress().equals(email))
            {
                request.setAttribute("message", "<div class=\"error\"> ERROR: E-mail address already registered  </div>");
            }else {
            	data.addUser(role, name, email, pass);
            }
        }
        
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	System.out.println("!! GET !!");
    	request.setAttribute("message", "SAJT");
    	
    }  
}

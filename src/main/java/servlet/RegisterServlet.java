package servlet;

import data.Data;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
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
        }
        
        //Empty fields
        if (firstName.equals("") || lastName.equals("") || email.equals("") || role.equals(""))
        {
        	request.setAttribute("message", "<div class=\"error\"> ERROR: Requested field is empty.  </div>");
        }
       

        Data data = Data.newInstance();
        
        System.out.println("email: " + email);
        
//        for (User u: data.getUserList())
//        {
//        	System.out.println("u: " + u);  	
//        	
//            if(u.getEmailAddress().equals(email))
//            {
//                request.setAttribute("message", "<div class=\"error\"> ERROR: E-mail address already registered  </div>");
//            }else {
//            	data.addUser(firstName, lastName, email, role, pass);
//            }
//        }
        
        boolean alreadyExist = false;
        System.out.println(data.getUserList().size());

        for(User u: data.getUserList()){
        	System.out.println("u: " + u.toString());  
        	if(u.getEmailAddress().equals(email)){
        		alreadyExist = true;
        	}
        }
        
        if(!alreadyExist){
        	System.out.println("u: " +"szar"); 
        	data.addUser(role, firstName, lastName, email, pass);
        	request.setAttribute("message", "<div class=\"success\"> SUCCESS: You succesfully created an account.  </div>");
        } else {
        	request.setAttribute("message", "<div class=\"error\"> ERROR: E-mail address already registered  </div>");
        }
        System.out.println(data.getUserList().size());
        
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	System.out.println("!! GET !!");
    	request.setAttribute("message", "SAJT");
    	
    }
    
    public static String encrypt(String source) {
    	   String md5 = null;
    	   try {
    	         MessageDigest mdEnc = MessageDigest.getInstance("MD5"); //Encryption algorithm
    	         mdEnc.update(source.getBytes(), 0, source.length());
    	         md5 = new BigInteger(1, mdEnc.digest()).toString(16); // Encrypted string
    	        } 
    	    catch (Exception ex) {
    	         return null;
    	    }
    	    return md5;
    	}
}

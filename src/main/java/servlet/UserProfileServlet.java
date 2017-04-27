package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Data;
import user.User;

/**
 * Servlet implementation class UserProfileServlet
 */
public class UserProfileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3172148145175828381L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Data d = Data.newInstance();
		
		User currentUser = null;
    	HttpSession session = request.getSession(false);
    	
    	if(session != null){
    		currentUser = (User) request.getSession(false).getAttribute("user");
    	}
		
		if (currentUser == null)
		{
			response.sendRedirect("./login");
			return;
		}else{
			request.setAttribute("extramenu", currentUser.getFirstName());
			request.setAttribute("extraurl", "./profile");
		}
		
		try {
			if(request.getParameter("first").equals("yes")){
				request.setAttribute("message", "<div id=\"hideable\" class=\"success\"> SUCCESS: You successfully logged in. </div>");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.setAttribute("fullname", currentUser.getFullName());
		request.setAttribute("email", currentUser.getEmailAddress());
		request.setAttribute("role", currentUser.getRole().toUpperCase());
		request.setAttribute("address", request.getRemoteAddr());
		
		request.setAttribute("fullname", currentUser.getFullName());
		request.getRequestDispatcher("/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

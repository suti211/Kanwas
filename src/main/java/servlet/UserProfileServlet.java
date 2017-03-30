package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Data data = Data.newInstance();
		User currentUser = data.getCurrentUser();
		
		request.setAttribute("name", currentUser.getFullName());
		request.setAttribute("email", currentUser.getEmailAddress());
		request.setAttribute("role", currentUser.getRole());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Data data = Data.newInstance();
		User currentUser = data.getCurrentUser();
		
		String inputFirstName = request.getParameter("inputFirstName");
		String inputLastName = request.getParameter("inputLastName");
		String inputRole = request.getParameter("inputRole");
		
		currentUser.setFirstName(inputFirstName);
		currentUser.setLastName(inputLastName);
		if(!currentUser.getRole().equals(inputRole))
			currentUser.changeRole();
		
		doGet(request, response);
		
	}

}

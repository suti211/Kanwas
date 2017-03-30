package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		
		Data d = Data.newInstance();
		User currentUser = d.getCurrentUser(d.getCookie(request));
		if (currentUser == null)
		{
			request.setAttribute("extramenu", "Click here to log in.");
			request.setAttribute("extraurl", "./login");
		}else{
			request.setAttribute("extramenu", currentUser.getFirstName());
			request.setAttribute("extraurl", "./profile");
		}
		
		
		String tableContent = "<table>" + 
				"<tbody>" + 
						"<tr class=\"head\">" + 
						"<td> <b>Name</b> </td>" + 
						"<td> <b>E-Mail</b> </td>" + 
						"<td> <b>Role</b> </td>" + 
						"</tr>";
		
		tableContent += "<tr>" +
				"<td>" + currentUser.getFullName() + "</td>"+
				"<td>" + currentUser.getEmailAddress() + "</td>" + 
				"<td>" + currentUser.getRole() + "</td>" + 
				"</tr>";

		tableContent += "</tbody>" + 
					"</table>";
		
		
		
		request.setAttribute("tableContent", tableContent);
		request.getRequestDispatcher("/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}
	
}

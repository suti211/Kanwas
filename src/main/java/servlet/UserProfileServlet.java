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
		/**Data data = Data.newInstance();
		User currentUser = data.getCurrentUser();
		
		request.setAttribute("name", currentUser.getFullName());
		request.setAttribute("email", currentUser.getEmailAddress());
		request.setAttribute("role", currentUser.getRole());*/
		
		Data d = Data.newInstance();
		User currentUser = d.getCurrentUser(getCookie(request));
		if (currentUser == null)
		{
			response.sendRedirect("./login.jsp");
			return;
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

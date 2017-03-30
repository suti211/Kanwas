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
 * Servlet implementation class UserListServlet
 */
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Data d = Data.newInstance();
		User currentUser = d.getCurrentUser(getCookie(request));
		if (currentUser == null)
		{
			response.sendRedirect("./login.jsp");
			return;
		}
		
		Data data = Data.newInstance();
		String name;
		String email;
		String role;
		String tableContent = "";
		
		tableContent += "<table>" + 
		"<tbody>" + 
				"<tr class=\"head\">" + 
				"<td> <b>Name</b> </td>" + 
				"<td> <b>E-Mail</b> </td>" + 
				"<td> <b>Role</b> </td>" + 
				"</tr>";
		
		
		for (User user : data.getUserList()) {
			name = user.getFullName();
			email = user.getEmailAddress();
			role = user.getRole();
			
			tableContent += "<tr>" +
							"<td>" + name + "</td>"+
							"<td>" + email + "</td>" + 
							"<td>" + role + "</td>" + 
							"</tr>";
		}
		
		tableContent += "</tbody>" + 
						"</table>";
		
		//TODO: data.getCurrentUser().getFullName()
		request.setAttribute("fullname", "Dezső");
		request.setAttribute("tableContent", tableContent);
		System.out.println("Table content generated and sent!");
		
		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
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

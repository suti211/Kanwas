package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
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
		Data data = Data.newInstance();
		String name;
		String email;
		String role;
		String tableContent = null;
		
		tableContent.join(""
				, "<table>"
				, "<tbody>"
				,"<tr>"
				,"<td> Name </td>"
				,"<td> E-Mail </td>"
				,"<td> Role </td>"
				,"</tr>");
		
		
		for (User user : data.getUserList()) {
			name = user.getFullName();
			email = user.getEmailAddress();
			role = user.getRole();
			
			tableContent.join(""
					,"<tr>"
					,"<td>" + name + "</td>"
					,"<td>" + email + "</td>"
					,"<td>" + role + "</td>"
					,"</tr>");
		}
		
		tableContent.join(""
				, "</tbody>"
				, "</table>");
		
		request.setAttribute("fullname", data.getCurrentUser().getFullName());
		request.setAttribute("tableContent", tableContent);
		System.out.println("Table content generated and sent!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

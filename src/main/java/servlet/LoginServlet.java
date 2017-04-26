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

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SQLConnector sqlConnector = new SQLConnector();
	private Data data = Data.newInstance();

	String email;
	String pass;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		email = request.getParameter("email");
		pass = request.getParameter("pass");

		/*
		 * Redirect user if logged in
		 * TODO: Filter
		 */
		User currentUser = (User) request.getSession(false).getAttribute("user");
		if (currentUser != null) {
			response.sendRedirect("./profile");
			return;
		}

		/*
		 * Check if Password & EMail are given and not empty
		 */
		if (email.equals("") || pass.equals("")) {
			request.setAttribute("message", "<div class=\"error\"> ERROR: Requested field is empty.  </div>");
			doGet(request, response);
			return;
		}

		/*
		 * Encrypt password
		 */
		pass = encrypt(pass);

		/*
		 * Check if user exist in DB
		 */
		if (getCurrentUser() == null) {
			request.setAttribute("message", "<div class=\"error\"> ERROR: E-mail or password is incorrect. </div>");
			doGet(request, response);
			return;
		}

		/*
		 * Check if password is correct
		 */
		if ( !getCurrentUser().getPassword().equals(pass) ) {

			request.setAttribute("message", "<div class=\"error\"> ERROR: E-mail or password is incorrect. </div>");
			doGet(request, response);
			return;
		}
		
		/*
		 * User successfully logged in!
		 */
		request.setAttribute("message", "<div class=\"success\"> SUCCESS: You logged in, nigga.  </div>");
		HttpSession session = request.getSession(true);
		session.setAttribute("user", getCurrentUser());
		response.sendRedirect("./profile?first=yes");
	}

	private User getCurrentUser() {
		ResultSet rs = sqlConnector.getData("SELECT Email FROM users WHERE Email = '" + email + "'");
		User user = null;

		try {
			if (rs.next()) {
				user = data.getUserByEmail(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Error @ getCurrentUser: " + e.getMessage());
			e.printStackTrace();
		}

		return user;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User currentUser = null;
		HttpSession session = request.getSession(false);

		if (session != null) {
			currentUser = (User) request.getSession(false).getAttribute("user");
		}

		if (currentUser == null) {
			request.setAttribute("extramenu", "Click here to log in.");
			request.setAttribute("extraurl", "./login");
		} else {
			request.setAttribute("extramenu", currentUser.getFirstName());
			request.setAttribute("extraurl", "./profile");
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}

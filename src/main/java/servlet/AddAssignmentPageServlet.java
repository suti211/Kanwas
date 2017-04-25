package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddAssignmentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddAssignmentPageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("rekveszt jött geci");
		
		String json = (String)request.getParameter("json");
		if(json != null){
			System.out.println(json);
			
		} else {
			System.out.println("szar vagy");
		}
		response.getWriter().write("szar");
		
	}

}

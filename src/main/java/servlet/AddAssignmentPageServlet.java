package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddAssignmentPageServlet
 */
public class AddAssignmentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAssignmentPageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String assignmentTitle = request.getParameter("assignmentTitle");
		String assignmentContent = request.getParameter("assignmentContent");
		int assignmentMaxPoint = Integer.parseInt(request.getParameter("assignmentMaxPoint"));
		
		System.out.println("Title: " + assignmentTitle + " , Content: " + assignmentContent + " , MaxPoint: " + assignmentMaxPoint);
		doGet(request, response);
	}

}

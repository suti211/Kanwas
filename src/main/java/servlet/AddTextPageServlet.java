package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import module.TextPage;


public class AddTextPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLoginManager LoginManager = UserLoginManager.getInstance();

    public AddTextPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String jsonString = null;
		
		if(request.getParameter("json") == null){
			System.out.println("'json' parameter is null!");
			return;
		}
				
		jsonString = request.getParameter("json");
		System.out.println("JSON String: " + jsonString);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		TextPage textpage = gson.fromJson(jsonString, TextPage.class);
		
		
	}

}

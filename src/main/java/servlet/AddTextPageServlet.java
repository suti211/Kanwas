package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.SQLConnector;
import io.SQLModuleManager;
import module.Module;
import user.User;


public class AddTextPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddTextPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("inbound POST request(AddTextPageServlet)");
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		if(user.getRole().equals("mentor")){
			String jsonString = null;
			
			if(request.getParameter("json") == null){
				System.out.println("'json' parameter is null!");
				return;
			}
					
			jsonString = request.getParameter("json");
			System.out.println("JSON String: " + jsonString);
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Module textpage = gson.fromJson(jsonString, Module.class);
			
			SQLModuleManager sqlManager = new SQLModuleManager();
			sqlManager.sendTextPageToDB(textpage);
			
		}
		else{
			System.out.println("Student tried to AddNewTextPage!");
		}		
	}
}

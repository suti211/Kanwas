package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.Data;
import module.Module;

public class CurriculumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLoginManager LoginManager = UserLoginManager.getInstance();
	private Data data = Data.newInstance();

	public CurriculumServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("káresz");
		List<Module> modules = data.getModules();
		String jsonString = null;
		List<String> modulesTitle = new ArrayList<>();

		if (modules.size() > 0 ) {
			for (Module module : modules) {
				if(module.isPublished())
					modulesTitle.add(module.getTitle());
					modulesTitle.add(module.getContent());
			}
			jsonString = new Gson().toJson(modules);
		}
		else{
			System.out.println("data.getModules() is NULL!");
		}

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		if (jsonString != null){
			System.out.println(jsonString);
			out.print(jsonString);
		}
		else
			System.out.println("jsonString is NULL!");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("jött valami szar");
	}

}

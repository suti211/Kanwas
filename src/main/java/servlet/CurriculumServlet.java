package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		List<Module> modules = null;
		String jsonString = null;
		List<String> modulesTitle = null;

		if (data.getModules() != null) {
			modules = data.getModules();
			for (Module module : modules) {
				modulesTitle.add(module.getTitle());
			}
			jsonString = new Gson().toJson(modulesTitle);
		}

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		if (jsonString != null)
			out.print(jsonString);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

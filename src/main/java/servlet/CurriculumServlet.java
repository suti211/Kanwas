package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import data.Data;
import io.SQLConnector;
import io.SQLModuleManager;
import module.Module;
import user.User;

public class CurriculumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Data data = Data.newInstance();
	private List<Module> modul = new ArrayList<>();
	private SQLModuleManager sqlModuleManager = new SQLModuleManager();

	public CurriculumServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inbound GET request(CurriculumServlet)");
		modul = sqlModuleManager.getModulesFromDB();

		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("No session found!");
			return;
		}
		User user = (User) session.getAttribute("user");
		if (user == null) {
			System.out.println("No user found in the current Session!");
			return;
		}

		String jsonString = null;
		List<Module> modulesToSend = new ArrayList<>();

		modul.sort(new ModuleComparator());
		System.out.println("Sorted modules:");
		System.out.println(modul);

		if (modul.size() > 0) {
			for (Module module : modul) {
				if (user.getRole().equals("mentor")) {
					modulesToSend.add(module);
				} else {
					if (module.isPublished() == 1) {
						modulesToSend.add(module);
					}
				}
			}
			jsonString = new Gson().toJson(modulesToSend);
		} else {
			System.out.println("data.getModules() is NULL!");
		}

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		if (jsonString != null) {
			System.out.println(jsonString);
			out.print(jsonString);
		} else
			System.out.println("jsonString is NULL!");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inbound POST request(CurriculumServlet)");
		modul = sqlModuleManager.getModulesFromDB();
		SQLConnector sqlc = new SQLConnector();

		HttpSession session = request.getSession(false);
		if (session == null) {
			System.out.println("No session found!");
			return;
		}
		User user = (User) session.getAttribute("user");
		if (user.getRole().equals("student")) {
			System.out.println("Student tried to modify the module's order!");
			return;
		}

		int id = Integer.valueOf((String) request.getParameter("id"));
		int pageIndex = Integer.valueOf((String) request.getParameter("pageIndex"));

		for (Module module : modul) {
			if (module.getId() == id) {
				sqlc.sendQuery("UPDATE kanwas.modules SET indexID =" + pageIndex + " WHERE id = " + id);
				module.setIndex(pageIndex);
			}
		}

	}

	private class ModuleComparator implements Comparator<Module> {

		@Override
		public int compare(Module o1, Module o2) {
			if (o1.getIndex() > o2.getIndex())
				return 1;
			if (o1.getIndex() < o2.getIndex())
				return -1;
			else
				return 0;
		}
	}

}

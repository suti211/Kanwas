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
import module.Module;
import user.User;

public class CurriculumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Data data = Data.newInstance();
	private List<Module> modul = new ArrayList<>();

	public CurriculumServlet() {
		super();
		// -------FASS�G HOGY LEGYEN VALAMI
		//
		// Module m1 = new Module(1, "NIGGERFAGGOT", "pocs", null, 0, 0, 1);
		// Module m2 = new Module(2, "DISCO DISCO", "FISZ", null, 1, 1, 1);
		// Module m3 = new Module(3, "PARTY PARTY", "FASZ", null, 2, 2, 1);
		// Module m4 = new Module(4, "PICSAFuST", "SALEELUL", null, 3, 3, 1);
		// Module m5 = new Module(5, "FOSPISZTOLY", "SWAWARIM", null, 4, 4, 1);
		//
		// modul.add(m1);
		// modul.add(m2);
		// modul.add(m3);
		// modul.add(m4);
		// modul.add(m5);
		//
		// // ----------FASS�G V�GE
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inbound GET request(CurriculumServlet)");
		modul = getModulesFromDB();
		List<Module> modulesToSend = new ArrayList<>();

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
		modul = getModulesFromDB();
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

	private List<Module> getModulesFromDB() {
		SQLConnector sqlc = new SQLConnector();
		ResultSet rs = sqlc.getData("SELECT * FROM kanwas.modules;");
		List<Module> modulDB = new ArrayList<>();
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("Title");
				String content = rs.getString("Content");
				String type = rs.getString("Type");
				int maxScore = rs.getInt("MaxScore");
				int published = rs.getInt("Published");
				int indexid = rs.getInt("IndexID");
				modulDB.add(new Module(id, title, content, type, maxScore, published, indexid));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modulDB;
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

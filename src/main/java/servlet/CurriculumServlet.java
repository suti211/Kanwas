package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import module.Module;
import user.User;

public class CurriculumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Data data = Data.newInstance();
	private List<Module> modul = new ArrayList<>();

	public CurriculumServlet() {
		super();
		// -------FASSÁG HOGY LEGYEN VALAMI

		Module m1 = new Module("NIGGERFAGGOT", "ÁP ÁP DÉ", 0, 0, 1);
		Module m2 = new Module("DISCO DISCO", "FISZ", 1, 1, 1);
		Module m3 = new Module("PARTY PARTY", "FASZ", 2, 2, 1);
		Module m4 = new Module("PICSAFÜST", "SALEELUL", 3, 3, 1);
		Module m5 = new Module("FOSPISZTOLY", "SWAWARIM", 4, 4, 1);

		modul.add(m1);
		modul.add(m2);
		modul.add(m3);
		modul.add(m4);
		modul.add(m5);

		// ----------FASSÁG VÉGE
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inbound GET request(CurriculumServlet)");

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
		List<String> modulesTitle = new ArrayList<>();

		modul.sort(new ModuleComparator());
		System.out.println("Sorted modules:");
		System.out.println(modul);

		if (modul.size() > 0) {
			for (Module module : modul) {
				if (user.getRole().equals("mentor")) {
					modulesTitle.add(module.getTitle());
					modulesTitle.add(module.getContent());
				} else {
					if (module.isPublished() == 1) {
						modulesTitle.add(module.getTitle());
						modulesTitle.add(module.getContent());
					}
				}
			}
			jsonString = new Gson().toJson(modul);
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
		System.out.println("id : " + id);
		System.out.println("pageIndex : " + pageIndex);

		for (Module module : modul) {
			if (module.getId() == id) {
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

package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.SQLConnector;
import module.Module;
import user.Mentor;
import user.Student;
import user.User;

public class Data {

	private Map<User, String> sessions = new HashMap<>();
	private ArrayList<User> users = new ArrayList<User>();
	private User currentUser;
	private List<Module> modules;
	private GypsyModules dummyList;

	private SQLConnector sqlConnector = new SQLConnector();

	private static Data singleton = new Data();

	private Data() {
		dummyList = new GypsyModules();
		modules = dummyList.getModules();
	}

	public static Data newInstance() {
		return singleton;
	}

	public ArrayList<User> getUserList() {
		return users;
	}

	public User getCurrentUser(String sessionID) {
		for (Map.Entry<User, String> sess : sessions.entrySet()) {
			if (sessionID.equals(sess.getValue())) {
				return sess.getKey();
			}
		}
		return null;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public void addUser(String userType, String firstName, String lastName, String emailAddress) {
		addUser(userType, firstName, lastName, emailAddress, null);
	}

	public void addUser(String userType, String firstName, String lastName, String emailAddress, String password) {
		switch (userType) {
		case "student":
			users.add(new Student(firstName, lastName, emailAddress, userType, password));
			break;
		case "mentor":
			users.add(new Mentor(firstName, lastName, emailAddress, userType, password));
			break;
		}
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public User getUserbyName(String name) {
		for (User user : users) {
			if (user.getFullName().equals(name))
				return user;
		}
		return null;
	}

	private User createUserByID(String id) {
		ResultSet rs = sqlConnector.getData("SELECT * FROM Users WHERE id = '" + id + "'");
		User user = null;
		try {

			if (rs.next()) {

				if (rs.getString(6).equals("student")) {
					user = new Student(rs.getString(4), rs.getString(5), rs.getString(2), rs.getString(6),
							rs.getString(3));
				} else {
					user = new Mentor(rs.getString(4), rs.getString(5), rs.getString(2), rs.getString(6),
							rs.getString(3));
				}

				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public User getUserByEmail(String emailAddress) {
		ResultSet rs = sqlConnector.getData("SELECT id FROM USers WHERE Email = '" + emailAddress + "'");
		User user = null;

		try {
			if (rs.next()) {
				user = createUserByID(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Error @ getUserByEmail: " + e.getMessage());
			e.printStackTrace();
		}
		return user;
	}

	public boolean checkUserExist(String email) {
		ResultSet rs = sqlConnector.getData("SELECT id FROM users WHERE email = '" + email + "' LIMIT 1");
		try {

			if (!rs.next()) {
				return false;
			}
		} catch (SQLException e) {

			System.out.println("Error @ RegisterServlet: Checking if user exist: \n" + e.getMessage());
			e.printStackTrace();

		}

		return true;
	}

}

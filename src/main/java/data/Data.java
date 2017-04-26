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

	public List<User> getUserList() {
		ResultSet rs = sqlConnector.getData("SELECT id FROM Users");
		
		List<User> users = new ArrayList<>();
		try {
			while ( rs.next() )
			{
				users.add(createUserByID(rs.getString(1)));
			}
		} catch (SQLException e) {
			System.out.println("Error @ getUSerList: " + e.getMessage());
			e.printStackTrace();
		}
		
		return users;
	}
	
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
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

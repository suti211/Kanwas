package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.SQLConnector;
import user.Mentor;
import user.Student;
import user.User;

public class Data {

	private User currentUser;
	private SQLConnector sqlConnector = new SQLConnector();
	private static Data singleton = new Data();

	private Data() {
	}

	public static Data newInstance() {
		return singleton;
	}

	public List<User> getUserList() {
		ResultSet rs = sqlConnector.getData("SELECT id FROM Users");

		List<User> users = new ArrayList<>();
		try {
			while (rs.next()) {
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

	private User createUserByID(String id) {
		ResultSet rs = sqlConnector.getData("SELECT * FROM users WHERE id = '" + id + "'");
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
			e.printStackTrace();
		}
		return user;
	}

	public User getUserByEmail(String emailAddress) {
		ResultSet rs = sqlConnector.getData("SELECT id FROM users WHERE Email = '" + emailAddress + "'");
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
		ResultSet rs = sqlConnector.getData("SELECT id FROM users WHERE Email = '" + email + "' LIMIT 1");
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

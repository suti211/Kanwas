package servlet;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import data.Data;
import io.PersistentStorage;
import user.User;

@WebListener
public class ServletListener implements ServletContextListener {

	Data d = Data.newInstance();
	PersistentStorage ps = PersistentStorage.newInstance();
	List<User> users = d.getUserList();
	List<User> loadedUsers = loadUsers();

	@Override
	public final void contextInitialized(final ServletContextEvent sce) {
		if (users.size() < 1) {
			for(User u : loadedUsers ){
				users.add(u);
				System.out.println("user initialized: " + u);
			}
		}

	}

	@Override
	public final void contextDestroyed(final ServletContextEvent sce) {

	}

	private List<User> loadUsers() {
		List<User> dbUsers = null;
		try {
			dbUsers = ps.loadUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbUsers;
	}

}

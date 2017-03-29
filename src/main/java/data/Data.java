package data;

import java.util.ArrayList;

import user.Mentor;
import user.Student;
import user.User;

public class Data {
	private ArrayList<User> users = new ArrayList<User>();
	private User currentUser;
	
	private static Data singleton = new Data( );	
	private Data() { }

	public static Data newInstance( ) {
		return singleton;
	}

	public ArrayList<User> getUserList() {
		return users;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public void addUser(String userType, String name, String emailAddress){
		switch(userType){
		case "student":
			users.add(new Student(name, emailAddress, userType));
			break;
		case "mentor":
			users.add(new Mentor(name, emailAddress, userType));
			break;
		}
	}
	
	public void addUser(String userType, String name, String emailAddress, String password){
		switch(userType){
		case "student":
			users.add(new Student(name, emailAddress, userType, password));
			break;
		case "mentor":
			users.add(new Mentor(name, emailAddress, userType, password));
			break;
		}
	}
	
	public User getUserbyName(String name){
		for (User user : users) {
			if(user.getName().equals(name))
				return user;
		}
		return null;
	}
	
	public User getUserbyEmail(String emailAddress){
		for (User user : users) {
			if(user.getEmailAddress().equals(emailAddress))
				return user;
		}
		return null;
	}
	
	
	
}

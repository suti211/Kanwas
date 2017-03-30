package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import user.Mentor;
import user.Student;
import user.User;

public class Data {

	private Map<User, String> sessions = new HashMap<>();
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

	public void addUser(String userType, String firstName, String lastName, String emailAddress){
		switch(userType){
		case "student":
			users.add(new Student(firstName, lastName, emailAddress, userType));
			break;
		case "mentor":
			users.add(new Mentor(firstName, lastName, emailAddress, userType));
			break;
		}
	}
	
	public void addUser(String userType, String firstName, String lastName, String emailAddress, String password){
		switch(userType){
		case "student":
			users.add(new Student(firstName, lastName, emailAddress, userType, password));
			break;
		case "mentor":
			users.add(new Mentor(firstName, lastName, emailAddress, userType, password));
			break;
		}
	}
	
	public User getUserbyName(String name){
		for (User user : users) {
			if(user.getFullName().equals(name))
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

	public String stringGenerator() {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?#!+§/=(){}".toCharArray();
		String randString="";
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			char c = chars[random.nextInt(chars.length)];
			randString += c;
		}
		return randString;
	}

	public void putToMap(User u, String s)
	{
		sessions.put(u,s);
	}

	public Map<User, String> getCookies() {
		return sessions;
	}
}

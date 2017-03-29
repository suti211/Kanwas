package data;

import java.util.ArrayList;

import user.Mentor;
import user.Student;
import user.User;

public class Data {
	private ArrayList<User> users = new ArrayList<User>();
	
	private static Data singleton = new Data( );	
	private Data() { }

	public static Data newInstance( ) {
		return singleton;
	}

	public ArrayList<User> getUserList() {
		return users;
	}
	
	
	public void addUser(String userType, String name, String emailAddress){
		switch(userType){
		case "student":
			users.add(new Student(name, emailAddress));
			break;
		case "mentor":
			users.add(new Mentor(name, emailAddress));
			break;
		}
	}
	
	public void addUser(String userType, String name, String emailAddress, String userName, String password){
		switch(userType){
		case "student":
			users.add(new Student(name, emailAddress, userName, password));
			break;
		case "mentor":
			users.add(new Mentor(name, emailAddress, userName, password));
			break;
		}
	}
	
	
	
}

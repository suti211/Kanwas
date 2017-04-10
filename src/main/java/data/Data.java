package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
	
	public User getCurrentUser(String sessionID) {
		for (Map.Entry<User, String> sess : sessions.entrySet())
		{
			if (sessionID.equals(sess.getValue()))
			{
				return sess.getKey();
			}
		}
		return null;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public void addUser(String userType, String firstName, String lastName, String emailAddress){
		addUser(userType, firstName, lastName, emailAddress, null);
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

	public Map<User, String> getSessions() {
		return sessions;
	}
	
	//TODO: Implement
	public String getCookie(HttpServletRequest request)
	{	
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		{
			for (int i = 0; i < cookies.length; i++)
			{
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("sessionID"))
				{	
					return cookie.getValue(); 
				}        	
			}
			return "";
		}
		return "";
	}
}

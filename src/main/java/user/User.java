package user;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import io.PersistentStorage;

public abstract class User {
	private String firstName;
	private String lastName;
	private String emailAddress;	
	private String password;	
	private String role;
	
	public User(String firstName, String lastName, String emailAddress, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.role = role;
		
		addToLocalDB(this);
	}
	
	public User(String firstName, String lastName, String emailAddress, String role, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.role = role;
		this.password = password;
		
		addToLocalDB(this);
	}
	
	public void changeRole(){
		if(role.equals("student"))
			role = "mentor";
		else
			role = "student";
		
		modifyToLocalDB(this);
	}
	
	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getFullName()
	{
		return firstName + " " + lastName;
	}
	
	public void setFirstName(String name) {
		this.firstName = name;

		modifyToLocalDB(this);
	}
	
	public void setLastName(String name) {
		this.lastName = name;

		modifyToLocalDB(this);
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "User [name=" + getFullName() + ", emailAddress=" + emailAddress + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	private void addToLocalDB(User user){
		PersistentStorage ps = PersistentStorage.newInstance();
		try {
			ps.addUser(user);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void modifyToLocalDB(User user){
		PersistentStorage ps = PersistentStorage.newInstance();
		try {
			ps.modifyUser(user);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
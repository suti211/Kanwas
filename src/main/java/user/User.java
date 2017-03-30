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
		
		saveToLocalDB(this);
	}
	
	public User(String firstName, String lastName, String emailAddress, String role, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.role = role;
		this.password = password;
		
		saveToLocalDB(this);
	}
	
	public void changeRole(){
		if(role.equals("student"))
			role = "mentor";
		else
			role = "student";
		
		saveToLocalDB(this);
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

		saveToLocalDB(this);
	}
	
	public void setLastName(String name) {
		this.lastName = name;

		saveToLocalDB(this);
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "User [name=" + getFullName() + ", emailAddress=" + emailAddress + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	private void saveToLocalDB(User user){
		PersistentStorage ps = PersistentStorage.newInstance("src/main/java/io/user-db.xml");
		try {
			ps.modifyUser(user);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
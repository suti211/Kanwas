package user;

import io.PersistentStorage;

public abstract class User {
	private String name;
	private String emailAddress;	
	private String password;	
	private String role;
	
	public User(String name, String emailAddress, String role) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.role = role;
	}
	
	public User(String name, String emailAddress, String role, String password) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.role = role;
		this.password = password;
	}
	
	public void changeRole(){
		if(role.equals("student"))
			role = "mentor";
		else
			role = "student";
		
		PersistentStorage ps = PersistentStorage.newInstance("src/main/java/io/user-db.xml");
		try {
			ps.modifyUser(this);				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

		PersistentStorage ps = PersistentStorage.newInstance("src/main/java/io/user-db.xml");
		try {
			ps.modifyUser(this);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", emailAddress=" + emailAddress + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
}
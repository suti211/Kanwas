package user;

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
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	
	
}
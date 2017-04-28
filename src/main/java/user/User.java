package user;

public abstract class User {
	private String firstName;
	private String lastName;
	private String emailAddress;	
	private String password;	
	private String role;
	
	public User(String firstName, String lastName, String emailAddress, String role, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.role = role;
		this.password = password;
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
	
	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "User [name=" + getFullName() + ", emailAddress=" + emailAddress + ", password=" + password + ", role=" + role
				+ "]";
	}
		
}
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
		
		// swap this to sql update : addToLocalDB(this);
	}
	
	public void changeRole(){
		if(role.equals("student"))
			role = "mentor";
		else
			role = "student";
		
		// swap this to sql update : modifyToLocalDB(this);
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

		// swap this to sql update : modifyToLocalDB(this);
	}
	
	public void setLastName(String name) {
		this.lastName = name;

		// swap this to sql update : modifyToLocalDB(this);
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
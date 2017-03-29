package user;

public abstract class User {
	private String name;
	private String emailAddress;
	
	private String userName;
	private String password;
	
	
	
	public User(String name, String emailAddress) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
	}
	
	public User(String name, String emailAddress, String userName, String password) {
		super();
		this.name = name;
		this.emailAddress = emailAddress;
		this.userName = userName;
		this.password = password;
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
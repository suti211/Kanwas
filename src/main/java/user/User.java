package user;

public abstract class User {
	private String firstName;
	private String lastName;
	private String emailAddress;
	
	private String userName;
	private String password;
	
	public User(String firstName, String lastName, String emailAddress, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.userName = userName;
		this.password = password;
	}
	
	
}

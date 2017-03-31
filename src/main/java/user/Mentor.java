package user;

public class Mentor extends User{

	public Mentor(String firstName, String lastName, String emailAddress, String role, String password) {
		super(firstName, lastName, emailAddress, role, password);
		// TODO Auto-generated constructor stub
	}

	public Mentor(String firstName, String lastName, String emailAddress, String role) {
		super(firstName, lastName, emailAddress, role);
		// TODO Auto-generated constructor stub
	}

	public Mentor(String firstName, String lastName, String emailAddress, String role, String password,
			boolean saveFlag) {
		super(firstName, lastName, emailAddress, role, password, saveFlag);
	}
}
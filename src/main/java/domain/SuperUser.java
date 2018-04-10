package domain;

public class SuperUser extends PremiumUser{

	
	public SuperUser(String username, String email, String password) {
		super(username, email, password);
		// TODO Auto-generated constructor stub
	}

	private void addPremium(LoggedInUser user) {
		user.setPremium(true);
	}
}

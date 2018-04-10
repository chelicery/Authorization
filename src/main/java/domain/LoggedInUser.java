package domain;

public class LoggedInUser extends User {
	private String username;
	private String password;
	private String email;
	protected boolean premium;
	
	public LoggedInUser(String username, String email, String password){
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public boolean getPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	@Override
	public String toString() {
		String res;
		if(this.getPremium()) {
			res = "PREMIUM";
		}
		return ""+ this.getUsername() + "  " +this.getPremium();
	}
}

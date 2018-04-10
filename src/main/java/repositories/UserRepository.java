package repositories;

import java.util.ArrayList;

import domain.LoggedInUser;
import domain.User;

public class UserRepository {
	private static ArrayList<LoggedInUser> users = new ArrayList<LoggedInUser>();
	
	public static int add(LoggedInUser user) {
		if(users.add(user)) {
			return 1;
		} else return -1;
	}
	
	public int count() {
		return users.size();
	}
	
	public static ArrayList<LoggedInUser> getUsers(){
		return users;
	}
	
	
}

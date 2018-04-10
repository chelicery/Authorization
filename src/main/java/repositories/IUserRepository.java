package repositories;

import domain.LoggedInUser;
import domain.User;

public interface IUserRepository {
	public int count();
	public int add(LoggedInUser user);

}

package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.LoggedInUser;
import domain.User;
import repositories.IUserRepository;
import repositories.UserRepository;

@WebServlet("/userlist")
public class UsersListServlet extends HttpServlet{


	
	private static final long serialVersionUID = 1L;	
	ArrayList<LoggedInUser> users = UserRepository.getUsers();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		for(LoggedInUser u : users) {
			response.getWriter().println(u.toString());
	
}
	}
	
}

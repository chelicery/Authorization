package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoggedInUser;
import repositories.IUserRepository;
import repositories.UserRepository;

@WebServlet("/profile")
public class UserProfileServlet extends HttpServlet{
	
	/**
	 *
	 **/
	ArrayList<LoggedInUser> users = UserRepository.getUsers();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		Cookie ck[]=request.getCookies();
		LoggedInUser user = users.get(Integer.parseInt(userId));
		response.getWriter().println("Witaj" + user.getUsername());


	}
}

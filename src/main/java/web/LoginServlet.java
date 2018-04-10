package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoggedInUser;
import domain.User;
import repositories.IUserRepository;
import repositories.UserRepository;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserRepository users;
	int userId;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();
		response.getWriter().println(users.getUsers().size());
		
		try {
			if(validate(name, pass)){
				Cookie ck=new Cookie("userId", String.valueOf(userId));
				session.setAttribute("logged", userId);
				response.addCookie(ck);
				response.sendRedirect("/profile?id="+userId);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			
		}
			
		
		for(LoggedInUser u : users.getUsers()) {
			response.getWriter().println(u.getUsername());
			response.getWriter().println(u.getPassword());
		}
		response.getWriter().println("nie udało się zalogować");
		
		response.getWriter().println(UserRepository.getUsers().size());
//		response.sendRedirect("/login.jsp");
		
	}
	
	private boolean validate(String name, String pass) {
		
		for(LoggedInUser u : users.getUsers()) {
			if(u.getUsername().equalsIgnoreCase(name)){
				userId=users.getUsers().indexOf(u);
				return true;
			}

		}
		return false;
	}



	
	
}

package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoggedInUser;
import repositories.IUserRepository;
import repositories.UserRepository;


@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
		LoggedInUser user = retrieveConferenceApplicant(request);
		
//		session.setAttribute("logged", user);
//		
		UserRepository.add(user);
		
		System.out.println(UserRepository.getUsers().size());
		response.sendRedirect("/login.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	private LoggedInUser retrieveConferenceApplicant(HttpServletRequest request){
		return new LoggedInUser(request.getParameter("username"),
				request.getParameter("mail"),
				request.getParameter("password"));


	}
	
	
}

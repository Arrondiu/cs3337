package webtest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtest.model.User;
import webtest.service.DbService;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	// The doGet method gets information from the server
	// In this method, it receives request from Register.jsp and forwards the data to doPost
	// See /WEB-INF/Register.jsp for more information
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
	}

	// After retrieving data from /WEB-INF/Register.jsp, it gets sent to MySQL
	// See /webtest/service/DbService.java for more information
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// This retrieves the name "email" from /WEB-INF/Register.jsp
		String email = request.getParameter("email");
		// This retrieves the name "name" from /WEB-INF/Register.jsp
		String name = request.getParameter("name");
		// This retrieves the name "password" from /WEB-INF/Register.jsp
		String password = request.getParameter("password");
		
		// This creates the new user based on webtest/model/User.java
		User user = new User(email, name, password);
		// This calls the method DbService
		DbService dbService = new DbService();
		// This adds the user into MySQL
		dbService.addUser(user);
		// It directs the user to the Login.jsp
		response.sendRedirect("Login");
	}
}

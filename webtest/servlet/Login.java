package webtest.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtest.service.DbService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	// The doGet method gets information from the server
	// In this method, it receives request from Login.jsp and forwards the data to doPost
	// See /WEB-INF/Login.jsp for more information
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	// After retrieving data from Login.jsp, it gets sent to DbService (Our MySQL database)
	// See /webtest/DbService.java for more information
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// This is currently being used to see if there are no matching login. It would send the Failed message
		PrintWriter out = response.getWriter();
		// This retrieves the name "email" from Login.jsp
		String email = request.getParameter("email");
		// This retrieves the name "password" from Login.jsp
		String password = request.getParameter("password");
		
		// This calls the method DbService
		DbService dbService = new DbService();
		// It looks at the email and password inputted into the login form and compares it to the database
		if (dbService.loginUser(email, password)) {
			// If it matches, it directs the user to the Index.jsp
			response.sendRedirect("Index");
		} else {
			// If not, it prints out a page that says Failed
			out.print("Failed");
			// NOT FINISHED (This is what I want to do instead of saying a message)
			// Create a window pop-up that says that the email/password is incorrect
//			response.sendRedirect("Login");
		}
	}
}

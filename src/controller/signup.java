package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public signup() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("name");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		RequestDispatcher rd = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Boolean result = false;
		try {
			result = AuthDAO.checkUserNameAvailibility(username);
		
		if (result) {
			Boolean resultfinal;
			
				resultfinal = AuthDAO.enterNewUser(username,password, role,firstname,lastname);
				if (resultfinal) {
					request.setAttribute("error", "You are sucessfully registered");
					rd = request.getRequestDispatcher("/login.jsp");
					rd.include(request, response);

					
				} else {

					request.setAttribute("error", "Some Thing Bad Happned please try again after few seconds ");
					rd = request.getRequestDispatcher("/signup.jsp");
					rd.include(request, response);

				}
			} else {
				request.setAttribute("error", "User Name Already Exist");
				rd = request.getRequestDispatcher("/signup.jsp");
				rd.include(request, response);

			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
	
	}

}

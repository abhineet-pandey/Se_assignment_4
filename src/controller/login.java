package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AuthDAO;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		boolean result;
		try {
			result = AuthDAO.checkuserpassword(username, password, role);
		
		if (result) {
			int id_mcq=1;
			int id_num =1;
			AuthDAO authdo=new AuthDAO();
			authdo.getUser(username);
			authdo.getMCQuestions(id_mcq);
			authdo.getNuQuestions(id_num);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			request.getRequestDispatcher("/student.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "User Name/Password Error");
			rd = request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

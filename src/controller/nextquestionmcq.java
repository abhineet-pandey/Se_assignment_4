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
import model.MCQuestions;

/**
 * Servlet implementation class nextquestionmcq
 */
@WebServlet("/nextquestionmcq")
public class nextquestionmcq extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public nextquestionmcq() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String move = request.getParameter("move");
		System.out.println("hello " + move);
		MCQuestions mcq = new MCQuestions();
		int mcq_id = mcq.getqnomcq();
		AuthDAO authdo = new AuthDAO();

		if (move.equals("okay")) {
			try {
				if (mcq_id < authdo.numberofMCQId()) {
					mcq_id++;
					authdo.getMCQuestions(mcq_id);

					if (mcq_id == authdo.numberofMCQId()) {
						request.setAttribute("message", "This is the last Question");
					}
				} else {
					request.setAttribute("message", "You have completed all the questions no more questions left");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
		System.out.println(move);
		request.setAttribute("feedback", "Complete the question before moving further");
		}
		request.getRequestDispatcher("/answermcq.jsp").forward(request, response);

	}

}

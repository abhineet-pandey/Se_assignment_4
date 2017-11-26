package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;
import model.MCQuestions;

/**
 * Servlet implementation class multiplechoiceanswer
 */
@WebServlet("/multiplechoiceanswer")
public class multiplechoiceanswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public multiplechoiceanswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MCQuestions mcq = new MCQuestions();
		String answer = request.getParameter("answer");
		RequestDispatcher rd = null;
		response.setContentType("text/html");
		if (answer.equals(mcq.getanswer())) {
			if (answer.equals(mcq.getanswer())) {
				if (mcq.gethint_state() == 1) {
					request.setAttribute("hint1", mcq.gethint1());
				} else if (mcq.gethint_state() == 2) {
					request.setAttribute("hint1", mcq.gethint1());
					request.setAttribute("hint2", mcq.gethint2());

				} else if (mcq.gethint_state() == 3) {
					request.setAttribute("hint1", mcq.gethint1());
					request.setAttribute("hint2", mcq.gethint2());
					request.setAttribute("hint3", mcq.gethint3());
				}
				request.setAttribute("message", "Correct");
				request.setAttribute("move", "okay");
				request.setAttribute("feedback", mcq.getfeedback());
				rd = request.getRequestDispatcher("/answermcq.jsp");
				rd.include(request, response);
			}
		}else {
				if (mcq.gethint_state() == 0) {
					mcq.sethint_state(1);
					request.setAttribute("hint1", mcq.gethint1());
					request.setAttribute("message", "InCorrect");
				} else if (mcq.gethint_state() == 1) {
					mcq.sethint_state(2);
					request.setAttribute("hint1", mcq.gethint1());
					request.setAttribute("hint2", mcq.gethint2());
					request.setAttribute("message", "InCorrect");

				} else if (mcq.gethint_state() == 2) {
					mcq.sethint_state(3);
					request.setAttribute("hint1", mcq.gethint1());
					request.setAttribute("hint2", mcq.gethint2());
					request.setAttribute("hint3", mcq.gethint3());
					request.setAttribute("feedback", mcq.getfeedback());
					request.setAttribute("move", "okay");
					request.setAttribute("message", "correct answer is " + mcq.getanswer());

				} else {
					request.setAttribute("hint1", mcq.gethint1());
					request.setAttribute("hint2", mcq.gethint2());
					request.setAttribute("hint3", mcq.gethint3());
					request.setAttribute("feedback", mcq.getfeedback());
					request.setAttribute("move", "okay");
					request.setAttribute("message", "correct answer is " + mcq.getanswer());

				}

				rd = request.getRequestDispatcher("/answermcq.jsp");
				rd.include(request, response);
			}
		}

	}


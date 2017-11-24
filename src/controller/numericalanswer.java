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
import model.NuQuestions;

/**
 * Servlet implementation class multiplechoiceanswer
 */
@WebServlet("/numericalanswer")
public class numericalanswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public numericalanswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NuQuestions num = new NuQuestions();
		String answer = request.getParameter("answer");
		RequestDispatcher rd = null;
		response.setContentType("text/html");
		if (answer.equals(num.getanswer())) {
			if (answer.equals(num.getanswer())) {
				if (num.gethint_state() == 1) {
					request.setAttribute("hint1", num.gethint1());
				} else if (num.gethint_state() == 2) {
					request.setAttribute("hint1", num.gethint1());
					request.setAttribute("hint2", num.gethint2());

				} else if (num.gethint_state() == 3) {
					request.setAttribute("hint1", num.gethint1());
					request.setAttribute("hint2", num.gethint2());
					request.setAttribute("hint3", num.gethint3());
				}
				request.setAttribute("message", "Correct");
				request.setAttribute("over","complete");
				request.setAttribute("feedback", num.getfeedback());
				rd = request.getRequestDispatcher("/answernumerical.jsp");
				rd.include(request, response);
			}
		}else {
				if (num.gethint_state() == 0) {
					num.sethint_state(1);
					request.setAttribute("hint1", num.gethint1());
					request.setAttribute("message", "InCorrect");
				} else if (num.gethint_state() == 1) {
					num.sethint_state(2);
					request.setAttribute("hint1", num.gethint1());
					request.setAttribute("hint2", num.gethint2());
					request.setAttribute("message", "InCorrect");

				} else if (num.gethint_state() == 2) {
					num.sethint_state(3);
					request.setAttribute("hint1", num.gethint1());
					request.setAttribute("hint2", num.gethint2());
					request.setAttribute("hint3", num.gethint3());
					request.setAttribute("feedback", num.getfeedback());
					request.setAttribute("message", "correct answer is " + num.getanswer());

				} else {
					request.setAttribute("hint1", num.gethint1());
					request.setAttribute("hint2", num.gethint2());
					request.setAttribute("hint3", num.gethint3());
					request.setAttribute("feedback", num.getfeedback());
					request.setAttribute("message", "correct answer is " + num.getanswer());

				}

				rd = request.getRequestDispatcher("/answernumerical.jsp");
				rd.include(request, response);
			}
		}

	}


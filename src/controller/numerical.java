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

/**
 * Servlet implementation class numerical
 */
@WebServlet("/numerical")
public class numerical extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public numerical() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String hint1 = request.getParameter("hint1");
		String hint2 = request.getParameter("hint2");
		String hint3 = request.getParameter("hint3");
		String feedback = request.getParameter("feedback");

		RequestDispatcher rd = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Boolean result = false;
		try {
			result = AuthDAO.checkNuQuestion(question);
		
		if (result) {
			Boolean resultfinal;
			
				resultfinal = AuthDAO.enterNewNuQuestions(question,answer,hint1,hint2,hint3,feedback);
				if (resultfinal) {
					request.setAttribute("error", "Question Sucessfully Entered please enter next question or click on I am Done");
					rd = request.getRequestDispatcher("/numerical.jsp");
					rd.include(request, response);

					
				} else {

					request.setAttribute("error", "Some Thing Bad Happned please try again after few seconds ");
					rd = request.getRequestDispatcher("/numerical.jsp");
					rd.include(request, response);

				}
			} else {
				request.setAttribute("error", "Question Already exists");
				rd = request.getRequestDispatcher("/numerical.jsp");
				rd.include(request, response);

			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
	
	}

}

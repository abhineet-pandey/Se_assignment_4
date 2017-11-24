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
 * Servlet implementation class multiplechoice
 */
@WebServlet("/multiplechoice")
public class multiplechoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public multiplechoice() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String question = request.getParameter("question");
		String choiceA = request.getParameter("choiceA");
		String choiceB = request.getParameter("choiceB");
		String choiceC = request.getParameter("choiceC");
		String choiceD = request.getParameter("choiceD");
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
			result = AuthDAO.checkMCQuestionavalibility(question);
		
		if (result) {
			Boolean resultfinal;
			
				resultfinal = AuthDAO.enterNewMCQuestions(question,choiceA,choiceB,choiceC,choiceD,answer,hint1,hint2,hint3,feedback);
				if (resultfinal) {
					request.setAttribute("error", "Question Sucessfully Entered please enter next question or click on I am Done");
					rd = request.getRequestDispatcher("/multiplechoice.jsp");
					rd.include(request, response);

					
				} else {

					request.setAttribute("error", "Some Thing Bad Happned please try again after few seconds ");
					rd = request.getRequestDispatcher("/multiplechoice.jsp");
					rd.include(request, response);

				}
			} else {
				request.setAttribute("error", "Question Already Exist");
				rd = request.getRequestDispatcher("/multiplechoice.jsp");
				rd.include(request, response);

			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
	
	}

}

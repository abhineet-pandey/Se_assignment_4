package controller;

import java.io.IOException;
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
 * Servlet implementation class nextquestionnumerical
 */
@WebServlet("/nextquestionnumerical")
public class nextquestionnumerical extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nextquestionnumerical() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		NuQuestions num=new NuQuestions();
		int num_id =num.getqno();
		AuthDAO authdo =new AuthDAO();
		try {
			if (num_id < authdo.numberofNumId()) {
				num_id++;
			authdo.getNuQuestions(num_id);
			
			if (num_id == authdo.numberofNumId()) {
				request.setAttribute("message", "This is the last Question");
			}
			}
			else {
				request.setAttribute("message", "You have completed all the questions no more questions left");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			request.getRequestDispatcher("/answernumerical.jsp").forward(request, response);
		
		}

	}


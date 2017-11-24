package model;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class AuthDAO
 */
@WebServlet("/AuthDAO")
public class AuthDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Connection connectionmanager() {
		Connection con = null;
		try {
			String connectionURL = "jdbc:mysql://localhost/SE_HW_4";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = (Connection) DriverManager.getConnection(connectionURL, "root", "Password123");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static boolean checkuserpassword(String username, String password, String role) throws SQLException {
		boolean rtn;
		Connection conn = (Connection) connectionmanager();
		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("select * from user where username=? and password=? and role=? ");

		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, role);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			rtn = true;
		} else {
			rtn = false;
		}
		conn.close();
		return rtn;
	}

	public User getUserbyId(int userid) {
		return null;

	}

	public User getUser(String username) throws SQLException {
		int ident = 0;
		User e = new User();
		Connection conn = (Connection) connectionmanager();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from  user where username=?");

		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ident = rs.getInt(1);

			e.setUsername(rs.getString(2));
			System.out.println(rs.getString(2));
			e.setRole(rs.getString(3));
		}
		PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement("select * from  userprofile where id=?");

		ps1.setInt(1, ident);
		ResultSet rs1 = ps1.executeQuery();
		while (rs1.next()) {
			e.setfirstname(rs1.getString(2));
			e.setlastname(rs1.getString(3));
		}
		return e;
	}
	 public MCQuestions getMCQuestions(int id) throws SQLException {

		 int ident = 0;
			MCQuestions m = new MCQuestions();
			Connection conn = (Connection) connectionmanager();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from  mcquestions where mcq_id=?");

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//ident = rs.getInt(1);
				m.setqnomcq(rs.getInt(1));
				m.setquestion(rs.getString(2));
				m.setchoiceA(rs.getString(3));
				m.setchoiceB(rs.getString(4));
				m.setchoiceC(rs.getString(5));
				m.setchoiceD(rs.getString(6));
				m.setanswer(rs.getString(7));
				m.sethint1(rs.getString(8));
				m.sethint2(rs.getString(9));
				m.sethint3(rs.getString(10));
				m.setfeedback(rs.getString(11));
				m.sethint_state(0);
			}
			return m;
		}

	 public NuQuestions getNuQuestions(int id) throws SQLException {

		 int ident = 0;
			NuQuestions n = new NuQuestions();
			Connection conn = (Connection) connectionmanager();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from  nuquestion where nuq_id=?");

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//ident = rs.getInt(1);
				n.setqno(rs.getInt(1));
				n.setquestion(rs.getString(2));
				n.setanswer(rs.getString(3));
				n.sethint1(rs.getString(4));
				n.sethint2(rs.getString(5));
				n.sethint3(rs.getString(6));
				n.setfeedback(rs.getString(7));
				n.sethint_state(0);
			}
			return n;
		}


	public static boolean enterNewUser(String UserName, String Password, String role, String firstname, String lastname)
			throws SQLException {

		boolean result;
		Connection conn = (Connection) connectionmanager();
		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("insert into user(username,password,role) values(?,?,?)");

		ps.setString(1, UserName);
		ps.setString(2, Password);
		ps.setString(3, role);

		boolean rs = ps.execute();
		if (!rs) {
			result = true;
		} else {
			result = false;
		}
		if (result) {
			PreparedStatement ps1 = (PreparedStatement) conn
					.prepareStatement("insert into userprofile(firstname,lastname) values(?,?)");

			ps1.setString(1, firstname);
			ps1.setString(2, lastname);

			boolean rs1 = ps1.execute();
			if (!rs1) {
				result = true;
			} else {
				result = false;
			}
		} else
			result = false;
		conn.close();
		return result;
	}

	public static boolean enterNewMCQuestions(String question, String choiceA, String choiceB, String choiceC,
			String choiceD, String answer, String hint1, String hint2, String hint3, String feedback)
			throws SQLException {
		boolean result;
		Connection conn = (Connection) connectionmanager();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(
				"insert into mcquestions(question,choiceA,choiceB,choiceC,choiceD,answer,hint1,hint2,hint3,feedback) values(?,?,?,?,?,?,?,?,?,?)");

		ps.setString(1, question);
		ps.setString(2, choiceA);
		ps.setString(3, choiceB);
		ps.setString(4, choiceC);
		ps.setString(5, choiceD);
		ps.setString(6, answer);
		ps.setString(7, hint1);
		ps.setString(8, hint2);
		ps.setString(9, hint3);
		ps.setString(10, feedback);

		boolean rs = ps.execute();
		if (!rs) {
			result = true;
		} else {
			result = false;
		}
		conn.close();
		return result;
	}

	public static boolean enterNewNuQuestions(String question, String answer, String hint1, String hint2, String hint3,
			String feedback) throws SQLException {
		boolean result;
		Connection conn = (Connection) connectionmanager();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(
				"insert into nuquestion(question,answer,hint1,hint2,hint3,feedback) values(?,?,?,?,?,?)");

		ps.setString(1, question);
		ps.setString(2, answer);
		ps.setString(3, hint1);
		ps.setString(4, hint2);
		ps.setString(5, hint3);
		ps.setString(6, feedback);

		boolean rs = ps.execute();
		if (!rs) {
			result = true;
		} else {
			result = false;
		}
		conn.close();
		return result;
	}

	public static boolean checkUserNameAvailibility(String username) throws SQLException {
		Connection conn = (Connection) connectionmanager();
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select username from user where username=?");

		boolean result = false;
		try {
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {

				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		return result;

	}

	public static boolean checkMCQuestionavalibility(String question) throws SQLException {

		Connection conn = (Connection) connectionmanager();
		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("select question from mcquestions where question=?");

		boolean result = false;
		try {
			ps.setString(1, question);

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {

				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		return result;

	}

	public static boolean checkNuQuestion(String question) throws SQLException {

		Connection conn = (Connection) connectionmanager();
		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("select question from nuquestion where question=?");

		boolean result = false;
		try {
			ps.setString(1, question);

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {

				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		return result;

	}

	public int numberofMCQId() throws SQLException {
		Connection conn = (Connection) connectionmanager();
		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("select count(*) from mcquestions");
		ResultSet rs = ps.executeQuery();
		rs.next();
		int nummcq=rs.getInt(1);
		conn.close();
		System.out.println(nummcq);
		return nummcq;
	}

	public int numberofNumId() throws SQLException {
		Connection conn = (Connection) connectionmanager();
		PreparedStatement ps = (PreparedStatement) conn
				.prepareStatement("select count(*) from nuquestion");
		ResultSet rs = ps.executeQuery();
		rs.next();
		int nummcq=rs.getInt(1);
		conn.close();
		System.out.println(nummcq);
		return nummcq;
	}
}

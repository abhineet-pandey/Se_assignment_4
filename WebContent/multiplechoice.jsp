<%@page import="model.User"%>
<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h2>
	<%
		String login_msg = (String) request.getAttribute("error");
		if (login_msg != null)
			out.println("<font color=red size=4px>" + login_msg + "</font>");
	%>
</h2>
<body>
	<%
		if (session != null) {
			if (session.getAttribute("name") != null) {
				String name = (String) session.getAttribute("name");
				out.println("you are already logged in");
				response.sendRedirect("active.jsp");

			}

		}
	%>
	<%
			User user = new User();
			java.util.Date d = new java.util.Date();
			out.println("Welcome " + user.getRole() + " " + user.getfirstname() + " " +user.getlastname() +"!");
			out.println("          Current Time And Date is " + d.toString());
		%>
</body>
<form name="myForm" action="multiplechoice"
	onsubmit="return validateForm()" method="post">
	Question: <input type="text" name="question" placeholder="Question"><br>
	Choice A: <input type="text" name="choiceA" placeholder="choice1"><br>
	Choice B: <input type="text" name="choiceB" placeholder="choice2"><br>
	Choice C: <input type="text" name="choiceC" placeholder="choice3"><br>
	Choice D: <input type="text" name="choiceD" placeholder="choice3"><br>

	Answer : <select name="answer">
		<option value="a">A</option>
		<option value="b">B</option>
		<option value="c">C</option>
		<option value="d">D</option>
	</select> <br> Hint 1: <input type="text" name="hint1" placeholder="hint1">
	<br> Hint 2: <input type="text" name="hint2" placeholder="hint2">
	<br> Hint 3: <input type="text" name="hint3" placeholder="hint3">
	<br> FeedBack: <input type="text" name="feedback"
		placeholder="Feedback"> <br> <br> <input
		type="submit" value="Save and Next Question" /> <a href="student.jsp">I
		am Done </a>
</form>
</html>
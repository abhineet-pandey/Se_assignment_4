<%@page import="model.User"%>
<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script>
	function validateForm() {
		var question = document.myForm.question.value;
		var answer = document.myForm.answer.value;
		var hint1 = document.myForm.hint1.value;
		var hint2 = document.myForm.hint2.value;
		var hint3 = document.myForm.hint3.value;
		var feedback = document.myForm.feedback.value;

		if (question == null || question == "") {
			if (answer == null || answer == "") {
				alert("Enter question and answer.");
				return false;
			}
			alert("Question can't be blank.");
			return false;
		} else if (answer == null || answer == "") {
			alert("Answer can't be blank.");
			return false;
		}
		 else if (hint1 == null || hint1 == "") {
				alert("Hint1 can't be blank.");
				return false;
			}
		 else if (hint2 == null || hint2 == "") {
				alert("hint2 can't be blank.");
				return false;
			}
		 else if (hint3 == null || hint3 == "") {
				alert("Hint3 can't be blank.");
				return false;
			}
		 else if (feedback == null || feedback == "") {
				alert("Feedback can't be blank.");
				return false;
			}
	}
</script>
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

<form name="myForm" action="numerical" onsubmit="return validateForm()"
	method="post">
	Question: <input type="text" name="question" placeholder="question"><br>
	Answer :  <input type="text" name="answer" placeholder="answer"><br>
	Hint 1:   <input type="text" name="hint1" placeholder="hint1"> <br>
	Hint 2:   <input type="text" name="hint2" placeholder="hint2"> <br>
	Hint 3:   <input type="text" name="hint3" placeholder="hint3"> <br>
	FeedBack: <input type="text" name="feedback" placeholder="Feedback">
	<br> <br> <input type="submit" value="Save and Next Question" />
	<a href="student.jsp">I am Done </a>

</form>
</html>
<%@page import="model.User"%>
<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Assignment 4</title>

<meta name="description"
	content="Source code generated using layoutit.com">
<meta name="author" content="LayoutIt!">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<h2>
	
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
	
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h1 class="text-center text-primary">
			<%
			User user = new User();
			java.util.Date d = new java.util.Date();
			out.println("Welcome " + user.getRole() + " " + user.getfirstname() + " " +user.getlastname() +"!");
			
		%>
		</h1>
		</div>
	</div>
<h5 class="text-center">
	<%out.println("          Current Time And Date is " + d.toString()); %> </h5>
<script>
	function validateForm() {
		var question = document.myForm.question.value;
		var choiceA = document.myForm.choiceA.value;
		var choiceB = document.myForm.choiceB.value;
		var choiceC = document.myForm.choiceC.value;
		var choiceD = document.myForm.choiceD.value;
		var hint1 = document.myForm.hint1.value;
		var hint2 = document.myForm.hint2.value;
		var hint3 = document.myForm.hint3.value;
		var feedback = document.myForm.feedback.value;

		if (question == null || question == "") {
			alert("Question can't be blank.");
			return false;
		} else if (choiceA == null || choiceA == "") {
			alert("choiceA can't be blank.");
			return false;
		}
		else if (choiceB == null || choiceB == "") {
			alert("choiceB can't be blank.");
			return false;
		}
		else if (choiceC == null || choiceC == "") {
			alert("choiceC can't be blank.");
			return false;
		}
		else if (choiceD == null || choiceD == "") {
			alert("choiceD can't be blank.");
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

<form name="myForm" class="col-md-6 mb-3" action="multiplechoice"
	onsubmit="return validateForm()" method="post">
	<%
		String login_msg = (String) request.getAttribute("error");
		if (login_msg != null)
			out.println("<font color=red size=4px>" + login_msg + "</font>");
	%><br>
	Question: <input type="text" class="form-control" name="question" placeholder="question"><br>
	Choice A: <input type="text" class="form-control" name="choiceA" placeholder="choiceA"><br>
	Choice B: <input type="text" class="form-control" name="choiceB" placeholder="choiceB"><br>
	Choice C: <input type="text" class="form-control" name="choiceC" placeholder="choiceC"><br>
	Choice D: <input type="text" class="form-control" name="choiceD" placeholder="choiceD"><br>
	Answer : <select name="answer" class="form-control">
			<option value="a">A</option>
			<option value="b">B</option>
			<option value="c">C</option>
			<option value="d">D</option>
			</select> <br>
     Hint 1:   <input type="text" class="form-control" name="hint1" placeholder="hint1">
<br> Hint 2:  <input type="text" class="form-control" name="hint2" placeholder="hint2">
<br> Hint 3:  <input type="text" class="form-control" name="hint3" placeholder="hint3">
<br> FeedBack:<input type="text" class="form-control" name="feedback"placeholder="feedback"> <br> <br> 
			  <input type="submit" class="btn btn-primary" value="Save and Next Question" /> 
			  <button type="button" class="btn  btn">
<a href="student.jsp">I am Done </a></button>
</form>
</body>
</html>
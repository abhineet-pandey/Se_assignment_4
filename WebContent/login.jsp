<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">

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

</head>
<h2></h2>
<body>
	<%
		if (session != null) {
			if (session.getAttribute("name") != null) {
				String name = (String) session.getAttribute("name");
				out.println("you are already logged in");
				response.sendRedirect("student.jsp");

			}

		}
	%>
	<script>
		function validateForm() {
			var name = document.myForm.name.value;
			var password = document.myForm.password.value;
			if (name == null || name == "") {
				if (password == null || password == "") {
					alert("Enter UserName and Password.");
					return false;
				}
				alert("UserName can't be blank.");
				return false;
			} else if (password == null || password == "") {
				alert("Password can't be blank.");
				return false;
			}
		}
	</script>
	<div class="wrapper">
	
		<form name="myForm" class="form-signin" action="login"
			onsubmit="return validateForm()" method="post">
			<h1> Login</h1>
					<%
						String login_msg = (String) request.getAttribute("error");
						if (login_msg != null)
							out.println("<font color=red size=4px>" + login_msg + "</font>");
					%>
				<input type="text" class="form-control" name="name"
					placeholder="UserName">
				<input type="password" class="form-control" name="password"
					placeholder="Password">
				<select name="role" class="form-control" placeholder="Role">

					<option value="Student">I am a Student</option>
					<option value="TA">I am a TA</option>
					<option value="Instructor">I am an Instructor</option>

				</select>
			<input type="submit" class="btn btn-lg btn-primary btn-block"
				value="SignIn" />
				Not a member click here to <a href="signup.jsp"> Signup</a>
		</form>
		</div>
</body>
</html>
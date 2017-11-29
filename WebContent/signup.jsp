<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<head>
<body>
<%
	if (session != null) {
		if (session.getAttribute("name") != null) {
			String name = (String) session.getAttribute("name");

			response.sendRedirect("active.jsp");
			out.print("you are already logged in");

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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<div class="wrapper">

	<form name="myForm" class="form-signin" action="signup"
		onsubmit="return validateForm()" method="post">
			<%
				String login_msg = (String) request.getAttribute("error");
				if (login_msg != null)
					out.println("<font color=red size=4px>" + login_msg + "</font>");
			%>
		<h1>SignUp</h1>
			<input type="text" class="form-control" name="name"
				placeholder="UserName"><br> <input type="text"
				class="form-control" name="fname" placeholder="FirstName"><br>
				
			<input type="text" class="form-control" name="lname"
				placeholder="LastName"><br> <input type="password"
				class="form-control" name="password" placeholder="Password"><br>
				<select class="form-control" name="role" placeholder="Role">
					<option value="Student">I am a Student</option>
					<option value="TA">I am a TA</option>
					<option value="Instructor">I am an Instructor</option>
			</select><br> <input type="submit"
				class="btn btn-lg btn-primary btn-block" value="SignUp" />
				Click here to <a href="login.jsp">Login</a>
	</form></div>
</body>
</html>
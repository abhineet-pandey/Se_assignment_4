<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h2><%
String login_msg=(String)request.getAttribute("error");  
if(login_msg!=null)
out.println("<font color=red size=4px>"+login_msg+"</font>");
%></h2>
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
</body>
<form name="myForm" action="login"
	onsubmit="return validateForm()" method="post">
	<input type="text" name="name" placeholder="UserName"><br>
	<input type="password" name="password" placeholder="Password"><br>
	<select name="role" placeholder="Role">
		<option value="Student">I am a Student</option>
		<option value="TA">I am a TA</option>
		<option value="Instructor">I am an Instructor</option>

	</select><br> <input type="submit" value="SignIn" />
</form>
Not a member click here to <a href="signup.jsp"> Signup</a>
</html>
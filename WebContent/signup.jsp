<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<h2><%
String login_msg=(String)request.getAttribute("error");  
if(login_msg!=null)
out.println("<font color=red size=4px>"+login_msg+"</font>");
%></h2>
<form name="myForm" action="signup"
	onsubmit="return validateForm()" method="post">
	<input type="text" name="name" placeholder="UserName"><br>
	<input type="text" name="fname" placeholder="FirstName"><br>
	<input type="text" name="lname" placeholder="LastName"><br>
	<input type="password" name="password" placeholder="Password"><br>

	<select name="role" placeholder="Role">
		<option value="Student">I am a Student</option>
		<option value="TA">I am a TA</option>
		<option value="Instructor">I am an Instructor</option>
	</select><br> <input type="submit" value="SignUp" />
</form>


</head>
<body>

</body>
</html>
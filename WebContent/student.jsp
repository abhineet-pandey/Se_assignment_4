<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
			User user = new User();
			java.util.Date d = new java.util.Date();
			out.println("Welcome " + user.getRole() + " " + user.getfirstname() + " " +user.getlastname() +"!");
			out.println("          Current Time And Date is " + d.toString());
		%>
	<a href="createquestion.jsp"> Create Questions</a>
	<a href="answerquiz.jsp"> Answer Questions</a>
	<a href="logout.jsp">logout</a>
</body>

</html>
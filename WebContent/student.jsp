<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
	<div class="text-center text-primary"><br>
	<button type="button" class="btn  btn-lg">
		<a href="createquestion.jsp"> Create Questions</a> </button>
		<button type="button" class="btn  btn-lg">
	<a  href="answerquiz.jsp"> Answer Questions</a></button></div>
	<div class="text-center text-primary"><br>
	<button type="button" class="btn  btn-lg">
	<a  href="logout.jsp">logout</a></button></div>
</body>

</html>
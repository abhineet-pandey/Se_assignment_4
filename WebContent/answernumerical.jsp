<%@page import="model.NuQuestions"%>
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
			<br>
			<%NuQuestions num = new NuQuestions();
			out.println("\n");
			out.println("Q. No." + num.getqno() +" " + num.getquestion() + " ?");
		%><br>
		
		<form name="myForm" action="numericalanswer"
	onsubmit="return validateForm()" method="post">
	<br>
	<br>
	Your Answer is: 	<input type="text" name="answer" placeholder="Type Your Answer here"><br>

		
	</select> <br>
	<br>FeedBack : <%
String feedback=(String)request.getAttribute("feedback");  
if(feedback!=null)
out.println(" "+feedback+"");
%>
	<br><br><br>Hint 1:<%
String hint1=(String)request.getAttribute("hint1");  
if(hint1!=null)
out.println(" "+hint1+"");
%>
	<br><br>Hint 2:<%
String hint2=(String)request.getAttribute("hint2");  
if(hint2!=null)
out.println(" "+hint2+"");
%>
	<br><br>Hint 3:<%
String hint3=(String)request.getAttribute("hint3");  
if(hint3!=null)
out.println(" "+hint3+"");
%>
	<br><br>Mesage: <%
String msg=(String)request.getAttribute("message");  
if(msg!=null)
out.println(" "+msg+"");
%>
<br><input	type="submit" value="submit" /> 
</form><form name="myForm" action="nextquestionnumerical" onsubmit="return validateForm()" method="post">
	<input	type="submit" value="Next Question" />
</form>
<br>Click <a href="student.jsp">here</a> to go to home Page when finished <br>
	</body>
</html>
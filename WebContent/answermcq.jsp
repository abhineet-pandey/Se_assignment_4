<%@page import="model.MCQuestions"%>
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
			<%MCQuestions mcq = new MCQuestions();
			out.println("\n");
			out.println("Q. No." + mcq.getqnomcq() +" " + mcq.getquestion() + " ?");
		%><br>
		<br>Options are :<br><br>
		 A.
		<%out.println(" "+ mcq.getchoiceA()); %>
		<br> B.
		<%out.println(" "+ mcq.getchoiceB()); %>
		<br> C.
		<%out.println(" "+ mcq.getchoiceC()); %>
		<br> D.
		<%out.println(" "+ mcq.getchoiceD()); %>
		<form name="myForm" action="multiplechoiceanswer"
	onsubmit="return validateForm()" method="post">
	<br>
	<br>
	Your Answer is: <select name="answer">
		<option value="a">A</option>
		<option value="b">B</option>
		<option value="c">C</option>
		<option value="d">D</option>
		
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
</form><form name="myForm" action="nextquestionmcq"  method="post">
<%
String move=(String)request.getAttribute("move");  
if(move!=null)
%>
	 <input type="hidden" name="move" value=<%out.println(" "+move+"");%>><br>
	<input	type="submit" value="Next Question" />
</form>
<br>Click <a href="student.jsp">here</a> to go to home Page when finished <br>

	</body>

</html>
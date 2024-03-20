<%@page import="com.techpalle.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DISPLAY PAGE</title>
</head>
<body>
	<h1>Student details</h1>
	<%
	ArrayList<Student> al = (ArrayList<Student>)request.getAttribute("students");
	%>
	<table border="2">
	<%
	for(Student s : al)
	{
	%>
		<tr bgcolor = 'yellow'>
			<td><%=s.getSid()%></td>
			<td><%=s.getSname()%></td>
			<td><%=s.getSub()%></td>
			<td><%=s.getGender()%></td>
			<td><%=s.getEmail()%></td>
			<td><%=s.getEducation()%></td>
		</tr>
	<%
	}
	%>
	</table>
</body>
</html>
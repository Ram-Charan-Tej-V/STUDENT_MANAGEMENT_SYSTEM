<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>STUDENT REGISTRATION PAGE</title>
</head>
<body>
	<h1>INSERT STUDENT DETAILS HERE</h1>
	<form action="insertstudent" method="post">
		sname:<input type="text" name="sname" placeholder="enter name"/><br>
		sub:<input type="text" name="sub" placeholder="enter sub"/><br>
		gender:<input type = "radio" name="gender" value="Male"/>Male
			   <input type = "radio" name="gender" value ="female"/>Female<br>
		email:<input type="email" name="email" placeholder="enter email"/><br>
		education:<input type="text" name="education" placeholder="enter education"/><br>
		<input type="submit" value="Save"/><br>
	</form>
	<form action = "home">
		<input type ="submit" value="go home"/>
	</form>
</body>
</html>
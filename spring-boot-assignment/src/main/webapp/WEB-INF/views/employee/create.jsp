<%@page
	import="com.valtech.training.springbootassignment.models.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
	<%
	EmployeeModel emp = (EmployeeModel) request.getAttribute("employee");
	%>
	<form method="post" action="save?id=<%=emp.getId()%>">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName"/></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary"/></td>
			</tr>
			<tr>
				<td>Seniority</td>
				<td><input type="text" name="seniority"/></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><input type="text" name="experience"/></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
			<td>Department Id</td>
			<td><input type="text" name="department"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="Create" /> <input type="submit" name="cancel"
					value="Cancel" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
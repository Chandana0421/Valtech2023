<%@ page import="firstWeb.Employee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>

</head>
<body>
<h3>We are viewing an employee details</h3>

<% Employee emp = (Employee) request.getAttribute("emp"); %>
<table>
	<tr>
		<td>ID</td>
		<td><%= emp.getId()%></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><%= emp.getName()%></td>
	</tr>
	<tr>
		<td>Age</td>
		<td><%= emp.getAge()%></td>
	</tr>
	<tr>
		<td>Seniority</td>
		<td><%= emp.getSeniority()%></td>
	</tr>
	<tr>
		<td>Experience</td>
		<td><%= emp.getExperience()%></td>
	</tr>
	<tr>
		<td>Salary</td>
		<td><%= emp.getSalary()%></td>
	</tr>
		<tr>
		<td>Dept Id</td>
		<td><%= emp.getDeptId()%></td>
	</tr>

</table>

</body>
</html>
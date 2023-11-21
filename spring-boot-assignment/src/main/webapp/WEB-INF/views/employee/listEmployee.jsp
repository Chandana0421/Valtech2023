<%@page import="com.valtech.training.springbootassignment.models.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee list</title>
</head>
<body>
	<h1>List of employees</h1>
	<%
	List<EmployeeModel> employees = (List<EmployeeModel>) request.getAttribute("employee");
	%>

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Seniority</th>
			<th>Experience</th>
			<th>Salary</th>
			<th>Age</th>
			<th>Department Id</th>
		</tr>
		<%
		for (EmployeeModel e : employees) {
			request.setAttribute("e", e);
		%>
		<tr>
			<td>${e.id}</td>
			<td>${e.name}</td>
			<td>${e.seniority}</td>
			<td>${e.experience}</td>
			<td>${e.salary}</td>
			<td>${e.age}</td>
			<td>${e.department.id}</td>
			<td><a href="delete?id=${e.id}">Delete</a> <a
				href="edit?id=${e.id}">Edit</a>
				<a href="view?id=${e.id}">View</a></td>
		</tr>
		<%
		}
		%>
		
		<tfoot>
			<tr>
				<td colspan="8" align="right">
					<form action="new" method="get">
						<input type="submit" name="submit" value="New Employee" />
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>
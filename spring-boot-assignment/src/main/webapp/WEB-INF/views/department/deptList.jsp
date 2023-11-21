<%@page import="com.valtech.training.springbootassignment.models.EmployeeModel"%>
<%@page import="com.valtech.training.springbootassignment.models.DepartmentModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><h1>Department info</h1>
	<%
	DepartmentModel d = (DepartmentModel) request.getAttribute("department");
	request.setAttribute("d", d);
	%>
<form method="post" action="listEmployee">
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Location</th>
			<th>Employee</th>
		</tr>
		<tr>
			<td>${d.id}</td>
			<td>${d.name}</td>
			<td>${d.location}</td>
		</tr></table>
		<a href="next?id=${d.id}">Next</a> <a
				href="previous?id=${d.id}">Previous</a>
				<a href="first?id=${d.id}">First</a>
				<a href="last?id=${d.id}">Lst</a>
				</form>
		</table>
	<%
	List<EmployeeModel> emp = (List<EmployeeModel>) request.getAttribute("employees");
	%>
	
	<table>
	<tr>
	<th>Id</th>
			<th>Name</th>
			<th>Seniority</th>
			<th>Experience</th>
			<th>Salary</th>
			<th>Age</th>
	</tr>
	<%
		for (EmployeeModel e : emp) {
			request.setAttribute("e", e);
		%>
		<tr>
			<td>${e.id}</td>
			<td>${e.name}</td>
			<td>${e.seniority}</td>
			<td>${e.experience}</td>
			<td>${e.salary}</td>
			<td>${e.age}</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>

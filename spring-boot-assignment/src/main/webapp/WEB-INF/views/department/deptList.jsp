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
	<table>
		<tr>
			<td>Id</td>
			<td>: ${d.id}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>: ${d.name}</td>
		</tr>
		<tr>
		<td>Location</td>
		<td>: ${d.location}</td>
		</tr></table>
		<a href="next?id=${d.id}">Next</a> <a
				href="previous?id=${d.id}">Previous</a>
				<a href="first">First</a>
				<a href="last?id=${d.id}">Last</a>
				</form>
		</table>
	<%
	List<EmployeeModel> emp = (List<EmployeeModel>) request.getAttribute("employees");
	%>
	<h3>Employees in ${d.name}</h3>
	<table border="1">
	<tr>
	<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
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
			<td>${e.firstName}</td>
			<td>${e.lastName}</td>
			<td>${e.seniority}</td>
			<td>${e.experience}</td>
			<td>${e.salary}</td>
			<td>${e.age}</td>
			<%-- <td><a href="delete?id=${e.id}">Delete</a> <a
				href="edit?id=${e.id}">Edit</a>
				<a href="view?id=${e.id}">View</a></td> --%>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>

<%@page import="com.valtech.training.springbootassignment.models.EmployeeModel"%>
<%@page
	import="com.valtech.training.springbootassignment.models.DepartmentModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of departments</h1>
	<%
	List<DepartmentModel> dept = (List<DepartmentModel>) request.getAttribute("department");
	%>

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Location</th>
			<th>Employee</th>
		</tr>
		<%
		for (DepartmentModel d : dept) {
			request.setAttribute("d", d);
		%>
		<tr>
			<td>${d.id}</td>
			<td>${d.name}</td>
			<td>${d.location}</td>
			<td>${d.employees}</td>
			<td><a href="delete?id=${d.id}">Delete</a> <a
				href="edit?id=${d.id}">Edit</a> <a href="view?id=${d.id}">View</a></td>
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
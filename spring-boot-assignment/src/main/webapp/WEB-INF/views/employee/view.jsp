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
	<form method="post" action="listEmployee">
		<table border="1">
			<tr>
				<td>Id</td>
				<td><%=emp.getId()%></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><%=emp.getName()%></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><%=emp.getSalary()%></td>
			</tr>
			<tr>
				<td>Seniority</td>
				<td><%=emp.getSeniority()%></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><%=emp.getExperience()%></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><%=emp.getAge()%></td>
			</tr>
			<tr>
				<td>Department Id</td>
				<td><%=emp.getDepartment().getId()%></td>
			</tr> 
			<tr>
				<td colspan="2"><input type="submit" name="cancel"
					value="back" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
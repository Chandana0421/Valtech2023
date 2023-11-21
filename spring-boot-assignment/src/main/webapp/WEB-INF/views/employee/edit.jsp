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
				<td><input type="text" name="id" disabled="disabled"
					value="<%=emp.getId()%>" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="<%=emp.getName()%>>" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary"
					value="<%=emp.getSalary()%>" /></td>
			</tr>
			<tr>
				<td>Seniority</td>
				<td><input type="text" name="seniority"
					value="<%=emp.getSeniority()%>" /></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><input type="text" name="experience"
					value="<%=emp.getExperience()%>" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" value="<%=emp.getAge()%>" /></td>
			</tr>
			<tr>
				<td>Department Id</td>
				<td><input type="text" name="deptId"
					value="<%=emp.getDepartment().getId()%>" /></td>
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
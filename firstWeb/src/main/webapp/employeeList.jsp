<%@ page import="firstWeb.Employee"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<%
	List<Employee> empList = (List<Employee>) request.getAttribute("emp");
	%>


	<table border="1">
		<tr>
			<th>EmpId</th>
			<th>Name</th>
			<th>Age</th>
			<th>Seniority</th>
			<th>Salary</th>
			<th>DeptId</th>
			<th>Actions</th>
		</tr>
		<%
		if (empList != null) {
		%>
		<%
		// Assuming 'employees' is a list of Employee objects passed from a servlet
		for (Employee emp1 : empList) {
		%>
		<tr>
			<td><%=emp1.getId()%></td>
			<td><%=emp1.getName()%></td>
			<td><%=emp1.getAge()%></td>
			<td><%=emp1.getSeniority()%></td>
			<td><%=emp1.getSalary()%></td>
			<td><%=emp1.getDeptId()%></td>


			<td>
				<form action="employeeList" method="post">
					<input type="hidden" name="empId" value="<%=emp1.getId()%>">
					
					<input type="submit" name="submit" value="Edit">
				

					<input type="submit" name="submit" value="Delete">

					<input type="submit" name="submit" value="View">
				</form>

			</td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>
	<form action="employeeList" method="post">
	<input type="submit" name="submit" value="CreateNewEmployee">
	</form>
</body>
</html>

<%@ page import="firstWeb.Department"%>
<%@ page import="firstWeb.Employee"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee in Department</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<section class="container">
		<div
			class="row content d-flex justify-content-center align-items-center">
			<div class="col-md-5 cardclass">
				<div class="card shadow bg-white p-4">
					<h4 class="mb-4 text-center fs-1">Department Information</h4>
					<%
					Department dept = (Department) request.getAttribute("dept");
					%>
					<table>
						<tr>
							<td>ID</td>
							<td><%=dept.getId()%></td>
						</tr>
						<tr>
							<td>Name</td>
							<td><%=dept.getName()%></td>
						</tr>
						<tr>
							<td>Location</td>
							<td><%=dept.getLocation()%></td>
						<tr>
							<td colspan=2>
								<form action="departmentList" method="POST" class="mb-3 mt-3 text-center">
									<input type="submit" name="submit" value="First" /> <input
										type="submit" name="submit" value="Previous"  /> <input
										type="submit" name="submit" value="Next" /> <input
										type="submit" name="submit" value="Last"/>
								</form>
							</td>
						</tr>
					</table>

					<%
					List<Employee> empList = (List<Employee>) request.getAttribute("emp");
					%>


					<table border="1">
						<tr>
							<th>Employee Id</th>
							<th>Name</th>
							<th>Age</th>
							<th>Seniority</th>
							<th>Salary</th>
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
						</tr>
						<%
						}
						%>
					</table>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</section>

</body>
</html>
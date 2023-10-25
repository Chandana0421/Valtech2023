<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<form action="employeeList" method="post">
        <label for="empId">Emp ID:</label>
        <input type="number" id="empId" name="empId" required ><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>

        <label for="seniority">Seniority:</label>
        <input type="number" id="seniority" name="seniority" required><br>

        <label for="salary">Salary:</label>
        <input type="number" id="salary" name="salary" required><br>

        <label for="experience">Experience:</label>
        <input type="number" id="experience" name="experience" required><br>

        <label for="deptId">Dept ID:</label>
        <input type="number" id="deptId" name="deptId" required><br>

        <input type="submit" value="Submit" name="submit">
    </form>
</body>
</html>
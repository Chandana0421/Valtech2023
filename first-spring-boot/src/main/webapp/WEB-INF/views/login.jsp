<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="login">
		<table>
			<tr>
				<td>Username</td>
				<!-- value field default is the common practice -->
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>